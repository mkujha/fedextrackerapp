package com.demo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.client.FedexTrackerClient;
import com.demo.client.SwatchdaylightClient;
import com.demo.client.WriteEventLogDomain;
import com.demo.domain.WriteEventLog;
import com.demo.fedex.domain.Address;
import com.demo.fedex.domain.CompletedTrackDetail;
import com.demo.fedex.domain.CustomerExceptionRequestDetail;
import com.demo.fedex.domain.DeliveryOptionEligibilityDetail;
import com.demo.fedex.domain.Notification;
import com.demo.fedex.domain.NotificationSeverityType;
import com.demo.fedex.domain.TrackDetail;
import com.demo.fedex.domain.TrackEvent;
import com.demo.fedex.domain.TrackOtherIdentifierDetail;
import com.demo.fedex.domain.TrackReply;
import com.demo.fedex.domain.TrackRequest;
import com.demo.fedex.domain.TrackStatusAncillaryDetail;
import com.demo.fedex.domain.TrackStatusDetail;
import com.demo.fedex.domain.Weight;
import com.demo.swatchdaylight.reach4mobile.CtModestoWsaWsWriteEventLogRequest;
import com.demo.swatchdaylight.reach4mobile.WriteEventLogResponse;
import com.demo.util.DBConnector;

@Component
public class ScheduledTasks {

	@Autowired
	FedexTrackerClient fedexTrackerClient;
	@Autowired
	SwatchdaylightClient swatchdaylightClient;

	@Autowired
	@Resource(name = "demoDao")
	private DBConnector dbConnector;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	// @Scheduled(cron="0 0 8-10 * * *")
	public void callFedEx() throws SQLException {
		log.info("The time is now {}", dateFormat.format(new Date()));
		// WriteEventLog eventLog = new WriteEventLog();
		List<WriteEventLogDomain> events = dbConnector.getWriteEventLog();

		if (!events.isEmpty()) {
			Map<String, WriteEventLogDomain> uniqueTracking = new HashMap<String, WriteEventLogDomain>();
			for (WriteEventLogDomain tracking : events) {
				uniqueTracking.put(tracking.getTrackingNumber(), tracking);
			}
			//Calling to Fedex track operation
			TrackReply reply = fedexTrackerClient.trackFedEx(fedexTrackerClient.createRequest(events));
			log.info(" DB value" + reply);
			//
			if (reply != null) {
				if (printNotifications(reply.getNotifications())) {
					List<WriteEventLogDomain> statusList = new ArrayList<WriteEventLogDomain>();
					for (int i = 0; i < reply.getCompletedTrackDetails().size(); i++) {
						WriteEventLogDomain status = new WriteEventLogDomain();
						// package detail information
						if (status.getEventType() != null && status.getEventType().equalsIgnoreCase("DL")) {
							break;
						}
						boolean cont = true;
						log.info("--Completed Tracking Detail--");
						if (reply.getCompletedTrackDetails().get(i).getNotifications() != null) {
							log.info("  Completed Track Detail Notifications--");
							cont = printNotifications(reply.getCompletedTrackDetails().get(i).getNotifications());
							log.info("  Completed Track Detail Notifications--");
						}
						if (cont) {
							print("DuplicateWayBill", reply.getCompletedTrackDetails().get(i).isDuplicateWaybill());
							print("Track Details Count",
									reply.getCompletedTrackDetails().get(i).getTrackDetailsCount());
							if (reply.getCompletedTrackDetails().get(i).isMoreData()) {
								log.info("  Additional package data not yet retrieved");
								if (reply.getCompletedTrackDetails().get(i).getPagingToken() != null) {
									print("  Paging Token", reply.getCompletedTrackDetails().get(i).getPagingToken());
								}
							}
							printTrackDetail(reply.getCompletedTrackDetails().get(i).getTrackDetails(), status);
						}
						log.info("--Completed Tracking Detail--");
						statusList.add(status);
						
						//Updating DB with updated value
						//TODO need to be added validation if shipping event location change
						dbConnector.manageEvent(status, uniqueTracking.get(
								reply.getCompletedTrackDetails().get(i).getTrackDetails().get(0).getTrackingNumber()));
						
						//TODO need to be added validation if shipping event location change
						//calling to swatchdaylight service
						WriteEventLogResponse response = swatchdaylightClient.writeEventLog(this.createRequest(status));
						if(response != null){
							log.info("Response Code comming from swatchdaylight " + response.getReturn().getResultCode());
							
						}

					}
				}
				// printCompletedTrackDetail(reply.getCompletedTrackDetails(),
				// status);
				// dbConnector.manageEvent(status, eventLogDomain);
			}
			/* if (reply.getCompletedTrackDetails() != null) {
			 * printCompletedTrackDetail(reply.getCompletedTrackDetails(),
			 * status); } */
			if (reply != null && isResponseOk(reply.getHighestSeverity())) {
				log.info("--Track Reply--");
			}
		}
	}

	private com.demo.swatchdaylight.reach4mobile.WriteEventLog createRequest(WriteEventLogDomain writeEventLogDomain) {
		com.demo.swatchdaylight.reach4mobile.WriteEventLog eventLog = new com.demo.swatchdaylight.reach4mobile.WriteEventLog();
		CtModestoWsaWsWriteEventLogRequest request = new CtModestoWsaWsWriteEventLogRequest();
		request.setEventArrivalLocation(writeEventLogDomain.getEventArrivalLocation());
		request.setEventCity(writeEventLogDomain.getEventCity());
		request.setEventCountry(writeEventLogDomain.getEventCountry());
		// request.setEventDate(writeEventLogDomain.getEventDate());
		request.setEventState(writeEventLogDomain.getEventState());
		request.setEventStatusExceptionCode(writeEventLogDomain.getEventStatusExceptionCode());
		request.setEventDescription(writeEventLogDomain.getEventDescription());
		request.setEventType(writeEventLogDomain.getEventType());
		request.setEventZip(writeEventLogDomain.getEventZip());
		request.setEventStatusExceptionDesc(writeEventLogDomain.getStatusExceptionDescription());
		request.setTrackingNumber(writeEventLogDomain.getTrackingNumber());
		request.setInvoiceNo(Double.valueOf("123"));//TODO hard coding

		eventLog.setRequest(request);
		return eventLog;
	}

	private void printCompletedTrackDetail(List<CompletedTrackDetail> ctd, WriteEventLogDomain status) {
		for (int i = 0; i < ctd.size(); i++) { // package detail information
			if (status.getEventType() != null && status.getEventType().equalsIgnoreCase("DL")) {
				break;
			}
			boolean cont = true;
			log.info("--Completed Tracking Detail--");
			if (ctd.get(i).getNotifications() != null) {
				log.info("  Completed Track Detail Notifications--");
				cont = printNotifications(ctd.get(i).getNotifications());
				log.info("  Completed Track Detail Notifications--");
			}
			if (cont) {
				print("DuplicateWayBill", ctd.get(i).isDuplicateWaybill());
				print("Track Details Count", ctd.get(i).getTrackDetailsCount());
				if (ctd.get(i).isMoreData()) {
					log.info("  Additional package data not yet retrieved");
					if (ctd.get(i).getPagingToken() != null) {
						print("  Paging Token", ctd.get(i).getPagingToken());
					}
				}
				printTrackDetail(ctd.get(i).getTrackDetails(), status);
			}
			log.info("--Completed Tracking Detail--");

		}
	}

	private void printTrackDetail(List<TrackDetail> td, WriteEventLogDomain status) {

		for (int i = 0; i < td.size(); i++) {
			boolean cont = true;
			if (status.getEventType() != null && status.getEventType().equalsIgnoreCase("DL")) {
				break;
			}
			log.info("--Track Details--");
			if (td.get(i).getNotification() != null) {
				log.info("  Track Detail Notification--");
				cont = printNotifications(td.get(i).getNotification());
				log.info("  Track Detail Notification--");
			}
			if (cont) {
				print("Tracking Number", td.get(i).getTrackingNumber());
				print("Carrier code", td.get(i).getCarrierCode());
				if (td.get(i).getService() != null) {
					if (td.get(i).getService().getType() != null && td.get(i).getService().getDescription() != null) {
						print("Service", td.get(i).getService().getType());
						print("Description", td.get(i).getService().getDescription());
					}
				}

				if (td.get(i).getStatusDetail() != null) {
					log.info("--Status Details--");
					printStatusDetail(td.get(i).getStatusDetail());
					log.info("--Status Details--");
				}
				if (td.get(i).getOriginLocationAddress() != null) {
					log.info("--Origin Location--");
					print(td.get(i).getOriginLocationAddress());
					log.info("--Origin Location--");
				}
				if (td.get(i).getDestinationAddress() != null) {
					log.info("--Destination Location--");
					printDestinationInformation(td.get(i));
					log.info("--Destination Location--");
				}
				if (td.get(i).getActualDeliveryAddress() != null) {
					log.info("--Delivery Address--");
					print(td.get(i).getActualDeliveryAddress());
					log.info("--Delivery Address--");
				}

				if (td.get(i).getDeliveryAttempts().shortValue() > 0) {
					log.info("--Delivery Information--");
					printDeliveryInformation(td.get(i));
					log.info("--Delivery Information--");
				}

				if (td.get(i).getEvents() != null) {
					log.info("--Tracking Events--");
					printTrackEvents(td.get(i).getEvents(), status);
					log.info("--Tracking Events--");
				}
				log.info("--Track Details--");

			}
		}
	}

	private void printCustomerExceptionRequests(List<CustomerExceptionRequestDetail> exceptions) {
		if (exceptions != null) {
			for (int i = 0; i < exceptions.size(); i++) {
				CustomerExceptionRequestDetail exception = exceptions.get(i);
				print("Exception Id", exception.getId());
				print("Excpetion Status Code", exception.getStatusCode());
				print("Excpetion Status Description", exception.getStatusDescription());
				if (exception.getCreateTime() != null) {
					log.info("  Customer Exception Date--");
					print(exception.getCreateTime());
					log.info("  Customer Exception Date--");
				}
			}
		}
	}

	private void printTrackEvents(List<TrackEvent> events, WriteEventLogDomain status) {
		if (events != null) {
			for (int i = 0; i < events.size(); i++) {
				TrackEvent event = events.get(i);
				print("Event no. ", i);
				print(event.getTimestamp());

				print("Station Id", event.getStationId());
				print("Exception Code", event.getStatusExceptionCode());
				status.setEventStatusExceptionCode(event.getStatusExceptionCode());
				print("", event.getStatusExceptionDescription());
				status.setStatusExceptionDescription(event.getStatusExceptionDescription());
				print("Description", event.getEventDescription());
				status.setEventDescription(event.getEventDescription());

				if (event.getAddress() != null) {
					log.info("  Event Address--");
					printAddress(event.getAddress(), status);
					log.info("  Event Address--");
				}
				if (event.getEventType() != null && event.getEventType().equalsIgnoreCase("DL")) {
					status.setEventType(event.getEventType());
					break;
				}
				status.setEventType(event.getEventType());
				print("Type", event.getEventType());
			}
		}
	}

	private void printAddress(Address address, WriteEventLogDomain status) {
		if (address.getStreetLines() != null) {
			List<String> streetLines = address.getStreetLines();
			String street = "";
			for (int i = 0; i < streetLines.size(); i++) {
				if (streetLines.get(i) != null) {
					print("Street", streetLines.get(i));
					street = street + " " + streetLines.get(i);
					status.setEventArrivalLocation(street);
				}
			}
		}
		status.setEventCity(address.getCity());
		status.setEventZip(address.getPostalCode());
		status.setEventCountry(address.getCountryCode());
		status.setEventState(address.getStateOrProvinceCode());

	}

	private void printStatusDetail(TrackStatusDetail tsd) {
		if (tsd != null) {
			print(tsd.getCreationTime());
			print("Code", tsd.getCode());
			if (tsd.getLocation() != null) {
				log.info("--Location Address Detail--");
				print(tsd.getLocation());
				log.info("--Location Address Detail--");
			}
			if (tsd.getAncillaryDetails() != null) {
				log.info("--Ancillary Details--");
				// TODO complete details
				printAncillaryDetails(tsd.getAncillaryDetails());
				log.info("--Ancillary Details--");
			}
		}
	}

	private void printAncillaryDetails(List<TrackStatusAncillaryDetail> details) {
		if (details != null) {
			for (int i = 0; i < details.size(); i++) {
				if (details.get(i) != null) {
					if (details.get(i).getReason() != null && details.get(i).getReasonDescription() != null) {
						print(details.get(i).getReason(), details.get(i).getReasonDescription());
					}
				}
			}
		}
	}

	private void printDestinationInformation(TrackDetail td) {
		if (td.getDestinationAddress() != null) {
			print(td.getDestinationAddress());
		}
		print("Destination Type", td.getDestinationLocationType());
		print("Service Area", td.getDestinationServiceArea());
		print("Service Area Description", td.getDestinationServiceAreaDescription());
		print("Station Id", td.getDestinationStationId());
		print("Destination Timezone Offset", td.getDestinationLocationTimeZoneOffset());
	}

	private void printDeliveryOptionEligibility(List<DeliveryOptionEligibilityDetail> options) {
		for (int i = 0; i < options.size(); i++) {
			DeliveryOptionEligibilityDetail option = options.get(i);
			if (option != null) {
				print(option.getOption(), option.getEligibility());
			}
		}
	}

	private void printDeliveryInformation(TrackDetail td) {
		log.info("Delivery attempts: " + td.getDeliveryAttempts());
		print("Delivery Location", td.getDeliveryLocationDescription());
		print("Delivery Signature", td.getDeliverySignatureName());
		if (td.getDeliveryOptionEligibilityDetails() != null) {
			log.info("Delivery Options");
			printDeliveryOptionEligibility(td.getDeliveryOptionEligibilityDetails());
		}
	}

	private void printTrackOtherIdentifierDetail(List<TrackOtherIdentifierDetail> id) {
		if (id != null) {
			for (int i = 0; i < id.size(); i++) {
				if (id.get(i).getPackageIdentifier() != null) {
					print(id.get(i).getPackageIdentifier().getType(), id.get(i).getPackageIdentifier().getValue());
				}
			}
		}
	}

	private void printTime(Calendar calendar) {
		if (calendar != null) {
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int year = calendar.get(Calendar.YEAR);
			String date = new String(year + "-" + month + "-" + day);
			print("Date", date);
			printDOW(calendar);
		}
	}

	private void printAddress(Address address) {
		print("__________________________________");
		if (address.getStreetLines() != null) {
			List<String> streetLines = address.getStreetLines();
			for (int i = 0; i < streetLines.size(); i++) {
				if (streetLines.get(i) != null) {
					print("Street", streetLines.get(i));

				}
			}
		}
		print("City", address.getCity());
		print("State or Province Code", address.getStateOrProvinceCode());
		print("Postal Code", address.getPostalCode());
		print("Country Code", address.getCountryCode());
		if (address.isResidential()) {
			print("Address Type", "Residential");
		} else {
			print("Address Type", "Commercial");
		}

		print("__________________________________");
	}

	private void printDOW(Calendar calendar) {
		if (calendar != null) {
			String day;
			switch (calendar.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				day = "Sunday";
				break;
			case 2:
				day = "Monday";
				break;
			case 3:
				day = "Tuesday";
				break;
			case 4:
				day = "Wedensday";
				break;
			case 5:
				day = "Thursday";
				break;
			case 6:
				day = "Friday";
				break;
			case 7:
				day = "Saturday";
				break;
			default:
				day = "Invalid Date";
				break;
			}
			print("Day of Week", day);
		}
	}

	private boolean isResponseOk(NotificationSeverityType notificationSeverityType) {
		if (notificationSeverityType == null) {
			return false;
		}
		if (notificationSeverityType.equals(NotificationSeverityType.WARNING)
				|| notificationSeverityType.equals(NotificationSeverityType.NOTE)
				|| notificationSeverityType.equals(NotificationSeverityType.SUCCESS)) {
			return true;
		}
		return false;
	}

	private boolean printNotifications(Object n) {
		boolean cont = true;
		if (n != null) {
			List<Notification> notifications = null;
			Notification notification = null;
			if (n instanceof List) {
				notifications = (List<Notification>) n;
				if (notifications == null || notifications.size() == 0) {
					log.info("  No notifications returned");
				}
				for (int i = 0; i < notifications.size(); i++) {
					printNotification(notifications.get(i));
					if (!success(notifications.get(i))) {
						cont = false;
					}
				}
			} else if (n instanceof Notification) {
				notification = (Notification) n;
				printNotification(notification);
				if (!success(notification)) {
					cont = false;
				}
			}

		}
		return cont;
	}

	private void printNotification(Notification notification) {
		if (notification == null) {
			log.info("null");
		}
		NotificationSeverityType nst = notification.getSeverity();

		print("  Severity", (nst == null ? "null" : nst.value()));
		print("  Code", notification.getCode());
		print("  Message", notification.getMessage());
		print("  Source", notification.getSource());
	}

	private boolean success(Notification notification) {
		Boolean cont = true;
		if (notification != null) {
			if (notification.getSeverity() == NotificationSeverityType.FAILURE
					|| notification.getSeverity() == NotificationSeverityType.ERROR) {
				cont = false;
			}
		}

		return cont;
	}

	private void print(Object k, Object v) {
		if (k == null || v == null) {
			return;
		}
		String key;
		String value;
		if (k instanceof String) {
			key = (String) k;
		} else {
			key = k.toString();
		}
		if (v instanceof String) {
			value = (String) v;
		} else {
			value = v.toString();
		}
		log.info("  " + key + ": " + value);
	}

	private void print(Object o) {
		if (o != null) {
			if (o instanceof String) {
				log.info((String) o);
			} else if (o instanceof Address) {
				printAddress((Address) o);
			} else if (o instanceof Calendar) {
				printTime((Calendar) o);
			} else {
				log.info(o.toString());
			}

		}
	}

	private void printWeight(String msg, Weight weight) {
		if (msg == null || weight == null) {
			return;
		}
		log.info(msg + ": " + weight.getValue() + " " + weight.getUnits());
	}

	private String getSystemProperty(String property) {
		String returnProperty = System.getProperty(property);
		if (returnProperty == null) {
			return "XXX";
		}
		return returnProperty;
	}
}
