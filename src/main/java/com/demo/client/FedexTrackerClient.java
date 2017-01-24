
package com.demo.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.demo.fedex.domain.CarrierCodeType;
import com.demo.fedex.domain.ClientDetail;
import com.demo.fedex.domain.CompletedTrackDetail;
import com.demo.fedex.domain.TrackIdentifierType;
import com.demo.fedex.domain.TrackPackageIdentifier;
import com.demo.fedex.domain.TrackReply;
import com.demo.fedex.domain.TrackRequest;
import com.demo.fedex.domain.TrackSelectionDetail;
import com.demo.fedex.domain.TransactionDetail;
import com.demo.fedex.domain.VersionId;
import com.demo.fedex.domain.WebAuthenticationCredential;
import com.demo.fedex.domain.WebAuthenticationDetail;

//@Component
public class FedexTrackerClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(FedexTrackerClient.class);

	@Value("${fedex.endpoint}")
	String endpoint;
	@Value("${fedex.key}")
	String key;
	@Value("${fedex.password}")
	String password;
	@Value("${fedex.accountNumber}")
	String accountNumber;
	@Value("${fedex.meternumber}")
	String meternumber;

	public TrackReply trackFedEx(TrackRequest request) {
		TrackReply response = null;
		// WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
		// webServiceTemplate.setMarshaller(marshaller);
		// webServiceTemplate.setUnmarshaller(marshaller);
		try {
			response = (TrackReply) getWebServiceTemplate().marshalSendAndReceive(endpoint, request,
					new SoapActionCallback("http://fedex.com/ws/track/v12/track"));
			// Object responsea =
			// webServiceTemplate.marshalSendAndReceive(endpoint, request);
			// System.out.println(responsea.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public void printResponse(TrackReply response) {

		List<CompletedTrackDetail> forecastReturn = response.getCompletedTrackDetails();

		if (!forecastReturn.isEmpty()) {
			log.info("Result size " + forecastReturn.size());
			for (CompletedTrackDetail forecast : forecastReturn) {
				log.info("Result :  " + forecast.toString());
			}
		} else {
			log.info("No Response received");
		}
	}

	public TrackRequest createRequest(WriteEventLogDomain writeEventLog) {
		TrackRequest request = new TrackRequest();
		WebAuthenticationDetail authenticationDetail = new WebAuthenticationDetail();
		WebAuthenticationCredential authenticationCredential = new WebAuthenticationCredential();
		authenticationCredential.setKey(key);
		authenticationCredential.setPassword(password);
		authenticationDetail.setUserCredential(authenticationCredential);
		request.setWebAuthenticationDetail(authenticationDetail);
		ClientDetail clientdetail = new ClientDetail();
		clientdetail.setAccountNumber(accountNumber);
		clientdetail.setMeterNumber(meternumber);
		// clientdetail.setIntegratorId("123");
		// Localization localization = new Localization();
		// localization.setLanguageCode("EN");
		// localization.setLocaleCode("US");
		// clientdetail.setLocalization(localization);
		request.setClientDetail(clientdetail);
		TransactionDetail transactionDetail = new TransactionDetail();
		// transactionDetail.setLocalization(localization);
		request.setTransactionDetail(transactionDetail);
		VersionId versionId = new VersionId();
		versionId.setIntermediate(0);
		versionId.setMajor(12);
		versionId.setMinor(0);
		versionId.setServiceId("trck");
		request.setVersion(versionId);
		TrackSelectionDetail trackSelectionDetail = new TrackSelectionDetail();
		trackSelectionDetail.setCarrierCode(CarrierCodeType.FDXE);
		TrackPackageIdentifier trackPackageIdentifier = new TrackPackageIdentifier();
		trackPackageIdentifier.setType(TrackIdentifierType.TRACKING_NUMBER_OR_DOORTAG);
		trackPackageIdentifier.setValue(writeEventLog.getTrackingNumber());
		// trackSelectionDetail.setTrackingNumberUniqueIdentifier(writeEventLog.getTrackingNumber());
		trackSelectionDetail.setPackageIdentifier(trackPackageIdentifier);
		// trackSelectionDetail.setShipmentAccountNumber("510087020");
		// trackSelectionDetail.setSecureSpodAccount("510051408");
		/// PagingDetail pagingDetail = new PagingDetail();
		// pagingDetail.setNumberOfResultsPerPage(new BigInteger("100"));
		// pagingDetail.setPagingToken("100");
		// trackSelectionDetail.setPagingDetail(pagingDetail);
		request.getSelectionDetails().add(trackSelectionDetail);
		return request;
	}

	public TrackRequest createRequest(List<WriteEventLogDomain> events) {
		TrackRequest request = new TrackRequest();
		WebAuthenticationDetail authenticationDetail = new WebAuthenticationDetail();
		WebAuthenticationCredential authenticationCredential = new WebAuthenticationCredential();
		authenticationCredential.setKey(key);
		authenticationCredential.setPassword(password);
		authenticationDetail.setUserCredential(authenticationCredential);
		request.setWebAuthenticationDetail(authenticationDetail);
		ClientDetail clientdetail = new ClientDetail();
		clientdetail.setAccountNumber(accountNumber);
		clientdetail.setMeterNumber(meternumber);
		// clientdetail.setIntegratorId("123");
		// Localization localization = new Localization();
		// localization.setLanguageCode("EN");
		// localization.setLocaleCode("US");
		// clientdetail.setLocalization(localization);
		request.setClientDetail(clientdetail);
		TransactionDetail transactionDetail = new TransactionDetail();
		// transactionDetail.setLocalization(localization);
		request.setTransactionDetail(transactionDetail);
		VersionId versionId = new VersionId();
		versionId.setIntermediate(0);
		versionId.setMajor(12);
		versionId.setMinor(0);
		versionId.setServiceId("trck");
		request.setVersion(versionId);
		for (WriteEventLogDomain writeEventLog : events) {
			TrackSelectionDetail trackSelectionDetail = new TrackSelectionDetail();
			trackSelectionDetail.setCarrierCode(CarrierCodeType.FDXE);
			TrackPackageIdentifier trackPackageIdentifier = new TrackPackageIdentifier();
			trackPackageIdentifier.setType(TrackIdentifierType.TRACKING_NUMBER_OR_DOORTAG);
			trackPackageIdentifier.setValue(writeEventLog.getTrackingNumber());
			// trackSelectionDetail.setTrackingNumberUniqueIdentifier(writeEventLog.getTrackingNumber());
			trackSelectionDetail.setPackageIdentifier(trackPackageIdentifier);
			// trackSelectionDetail.setShipmentAccountNumber("510087020");
			// trackSelectionDetail.setSecureSpodAccount("510051408");
			/// PagingDetail pagingDetail = new PagingDetail();
			// pagingDetail.setNumberOfResultsPerPage(new BigInteger("100"));
			// pagingDetail.setPagingToken("100");
			// trackSelectionDetail.setPagingDetail(pagingDetail);
			request.getSelectionDetails().add(trackSelectionDetail);
		}
		return request;

	}
}
