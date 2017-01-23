package com.demo.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.demo.client.WriteEventLogDomain;

public class WriteEventLogExtractor implements ResultSetExtractor<List<WriteEventLogDomain>> {

	@Override
	public List<WriteEventLogDomain> extractData(ResultSet rs) throws SQLException, DataAccessException {
		ArrayList<WriteEventLogDomain> listOfEvent = new ArrayList<WriteEventLogDomain>();
		while (rs.next()) {
			WriteEventLogDomain writeEventLog = new WriteEventLogDomain();
			writeEventLog.setEventArrivalLocation(rs.getString("EVENTARRIVALLOCATION"));
			writeEventLog.setEventCity(rs.getString("EVENTCITY"));
			writeEventLog.setEventCountry(rs.getString("EVENTCOUNTRY"));
			writeEventLog.setEventDate(getXMLGregorianCalendar(rs.getTimestamp(("EVENTDATE"))));
			writeEventLog.setEventDescription(rs.getString("EVENTDESCRIPTION"));
			// STATUS
			writeEventLog.setInvoiceNo(rs.getString("INVOICE_NO"));
			writeEventLog.setEventZip(rs.getString("EVENTZIP"));
			writeEventLog.setEventState(rs.getString("EVENTSTATE"));
			writeEventLog.setEventType(rs.getString("EVENTTYPE"));
			writeEventLog.setTrackingNumber(rs.getString("TRACKING_NUMBER"));
			writeEventLog.setEventStatusExceptionCode(rs.getString("EVENTSTATUSEXCEPTIONCODE"));
			writeEventLog.setStatus(rs.getString("EVENTSTATUSEXCEPTIONCODE"));
			listOfEvent.add(writeEventLog);
		}
		return listOfEvent;
	}

	private XMLGregorianCalendar getXMLGregorianCalendar(Timestamp ts) {
		try {
			LocalDateTime ldt = ts.toLocalDateTime();
			XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			cal.setYear(ldt.getYear());
			cal.setMonth(ldt.getMonthValue());
			cal.setDay(ldt.getDayOfMonth());
			cal.setHour(ldt.getHour());
			cal.setMinute(ldt.getMinute());
			cal.setSecond(ldt.getSecond());
			cal.setFractionalSecond(new BigDecimal("0." + ldt.getNano()));
			return cal;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

}
