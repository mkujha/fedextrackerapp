package com.demo.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.client.WriteEventLogDomain;
import com.demo.details.domain.AddTrackingResponse;
import com.demo.details.domain.GetTrackingResponse;
import com.demo.details.domain.Tracking;

@Component
public class DBConnector {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<WriteEventLogDomain> getWriteEventLog() throws SQLException {
		return this.getJdbcTemplate().query("SELECT * FROM SHIPING_EVENT_LOG  where EVENTTYPE != 'DL'",
				new WriteEventLogExtractor());
	}

	public void manageEvent(WriteEventLogDomain status, WriteEventLogDomain eventLogDomain) {
		if (status.getEventType() != null && status.getEventType().equalsIgnoreCase("DL")) {
			this.getJdbcTemplate().update(
					"UPDATE SHIPING_EVENT_LOG set status = 'DELIVERED', EVENTARRIVALLOCATION=?, EVENTCITY=?, EVENTCOUNTRY=?, EVENTDATE=?, EVENTDESCRIPTION=?, "
							+ "EVENTSTATE=?, EVENTSTATUSEXCEPTIONCODE=?,EVENTSTATUSEXCEPTIONDESC=?, EVENTTYPE=?, EVENTZIP=? WHERE TRACKING_NUMBER =?",
					new Object[] { status.getEventArrivalLocation(), status.getEventCity(), status.getEventCountry(),
							status.getEventDate(), status.getEventDescription(), status.getEventState(),
							status.getEventStatusExceptionCode(), status.getStatusExceptionDescription(),
							status.getEventType(), status.getEventZip(), eventLogDomain.getTrackingNumber() });
			// Archive
			this.getJdbcTemplate().execute(
					"INSERT INTO shiping_event_log_ARCHIVE (ID, STATUS,EVENTARRIVALLOCATION, EVENTCITY, EVENTCOUNTRY, "
							+ "EVENTDATE, EVENTDESCRIPTION, EVENTSTATE, EVENTSTATUSEXCEPTIONCODE,EVENTSTATUSEXCEPTIONDESC,EVENTTYPE, "
							+ "EVENTZIP, INVOICE_NO,  TRACKING_NUMBER) SELECT ID, STATUS,EVENTARRIVALLOCATION, EVENTCITY, EVENTCOUNTRY, "
							+ "EVENTDATE, EVENTDESCRIPTION, EVENTSTATE, EVENTSTATUSEXCEPTIONCODE,EVENTSTATUSEXCEPTIONDESC, EVENTTYPE, "
							+ "EVENTZIP, INVOICE_NO,  TRACKING_NUMBER FROM shiping_event_log WHERE EVENTTYPE = 'DL'");
			// Delete
			this.getJdbcTemplate().execute("delete FROM shiping_event_log WHERE EVENTTYPE = 'DL'");
		} else if (status.getEventType() != null) {
			this.getJdbcTemplate().update(
					"UPDATE SHIPING_EVENT_LOG set EVENTARRIVALLOCATION=?, EVENTCITY=?, EVENTCOUNTRY=?, EVENTDATE=?, EVENTDESCRIPTION=?, "
							+ "EVENTSTATE=?, EVENTSTATUSEXCEPTIONCODE=?,EVENTSTATUSEXCEPTIONDESC=?, EVENTTYPE=?, EVENTZIP=? WHERE TRACKING_NUMBER =?",
					new Object[] { status.getEventArrivalLocation(), status.getEventCity(), status.getEventCountry(),
							status.getEventDate(), status.getEventDescription(), status.getEventState(),
							status.getEventStatusExceptionCode(), status.getStatusExceptionDescription(),
							status.getEventType(), status.getEventZip(), eventLogDomain.getTrackingNumber() });
		}

	}

	public GetTrackingResponse getTrackingDetails(String invoiceNo, String trackingNumber) {
		GetTrackingResponse getTrackingResponse = new GetTrackingResponse();
		String sql = "SELECT * FROM SHIPING_EVENT_LOG  where EVENTTYPE != 'DL'";
		List<String> args = new ArrayList<String>();
		List<WriteEventLogDomain> listOftrackingNo = new ArrayList<WriteEventLogDomain>();

		if (invoiceNo != null && !invoiceNo.equalsIgnoreCase("?")) {
			sql = sql + " AND INVOICE_NO=?";
			args.add(invoiceNo);
		}
		if (trackingNumber != null && !trackingNumber.equalsIgnoreCase("?")) {
			sql = sql + " AND TRACKING_NUMBER=?";
			args.add(trackingNumber);
		}
		if (!args.isEmpty()) {
			listOftrackingNo = this.getJdbcTemplate().query(sql, new WriteEventLogExtractor(), args.toArray());
		} else {
			listOftrackingNo = this.getJdbcTemplate().query(sql, new WriteEventLogExtractor(), args.toArray());
		}
		if (!listOftrackingNo.isEmpty()) {
			Tracking trackingdetail = null;
			for (WriteEventLogDomain eventLogDomain : listOftrackingNo) {
				trackingdetail = new Tracking();

				trackingdetail.setEventArrivalLocation(eventLogDomain.getEventArrivalLocation());
				trackingdetail.setEventCity(eventLogDomain.getEventCity());
				trackingdetail.setEventCountry(eventLogDomain.getEventCountry());
				// request.setEventDate(writeEventLogDomain.getEventDate());
				trackingdetail.setEventState(eventLogDomain.getEventState());
				trackingdetail.setEventStatusExceptionCode(eventLogDomain.getEventStatusExceptionCode());
				trackingdetail.setEventDescription(eventLogDomain.getEventDescription());
				trackingdetail.setEventType(eventLogDomain.getEventType());
				trackingdetail.setEventZip(eventLogDomain.getEventZip());
				// trackingdetail.setEventStatusExceptionDesc(eventLogDomain.getStatusExceptionDescription());
				trackingdetail.setTrackingNumber(eventLogDomain.getTrackingNumber());
				trackingdetail.setInvoiceNo(eventLogDomain.getInvoiceNo());// TODO
				getTrackingResponse.getTrackings().add(trackingdetail);
			}

		}
		return getTrackingResponse;
	}

	public AddTrackingResponse addTrackingDetails(String invoiceNo, String trackingNumber) {
		AddTrackingResponse addTrackingResponse = new AddTrackingResponse();
		int rawInserted = this.getJdbcTemplate().update(
				"INSERT INTO SHIPING_EVENT_LOG (INVOICE_NO,  TRACKING_NUMBER) values (?,?)",
				new Object[] { invoiceNo, trackingNumber });
		if (rawInserted > 0)
			addTrackingResponse.setStatus(true);
		else
			addTrackingResponse.setStatus(false);
		return addTrackingResponse;
	}

}
