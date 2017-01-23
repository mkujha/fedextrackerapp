package com.demo.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.client.WriteEventLogDomain;

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

}
