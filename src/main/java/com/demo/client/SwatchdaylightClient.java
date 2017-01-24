
package com.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.demo.swatchdaylight.reach4mobile.WriteEventLog;
import com.demo.swatchdaylight.reach4mobile.WriteEventLogResponse;

//@Component
public class SwatchdaylightClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(SwatchdaylightClient.class);

	@Value("${swatchdaylight.endpoint}")
	String endpoint;

	public WriteEventLogResponse writeEventLog(WriteEventLog request) {
		WriteEventLogResponse response = null;

		try {
			response = (WriteEventLogResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request,
					new SoapActionCallback("http://www.qualution.com/urn:writeEventLog"));
			// Object responsea =
			// webServiceTemplate.marshalSendAndReceive(endpoint, request);
			// System.out.println(responsea.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
