package com.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.details.domain.AddTrackingDetails;
import com.demo.details.domain.AddTrackingResponse;
import com.demo.details.domain.GetTrackingDetails;
import com.demo.details.domain.GetTrackingResponse;
import com.demo.util.DBConnector;

@Endpoint
public class TrackingDetailsServiceEndpoint {
	private static final String NAMESPACE_URI = "http://demo.com/ws/track/v12";

	@Autowired
	@Resource(name = "demoDao")
	DBConnector dbConnector;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTrackingDetails")
	@ResponsePayload
	public GetTrackingResponse getTrackingDetails(@RequestPayload GetTrackingDetails request) {
		GetTrackingResponse response = new GetTrackingResponse();

		response = dbConnector.getTrackingDetails(request.getInvoiceNo(), request.getTrackingNumber());

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addTrackingDetails")
	@ResponsePayload
	public AddTrackingResponse addTrackingDetails(@RequestPayload AddTrackingDetails request) {
		AddTrackingResponse response = new AddTrackingResponse();

		if (request.getInvoiceNo() == null || request.getTrackingNumber() == null) {
			response.setStatus(false);
		} else {
			response = dbConnector.addTrackingDetails(request.getInvoiceNo(), request.getTrackingNumber());
		}
		return response;
	}

}
