package com.demo;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import com.demo.client.FedexTrackerClient;
import com.demo.util.DBConnector;

@Configuration
public class WebServiceConfig {
	private static final Logger LOG = LoggerFactory.getLogger(WebServiceConfig.class);


	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean
	public Jaxb2Marshaller marshallerClientMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.demo.fedex.domain");
		//marshaller.setPackagesToScan("");
		return marshaller;
	}

	@Bean
	public FedexTrackerClient quoteClient(Jaxb2Marshaller marshaller) {
		FedexTrackerClient client = new FedexTrackerClient();
		client.setDefaultUri("https://wsbeta.fedex.com:443/web-services/track");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean("TrackerService")
	public SimpleWsdl11Definition definition1509() {
		SimpleWsdl11Definition wsdl = new SimpleWsdl11Definition();
		wsdl.setWsdl(customerServiceWsdl());
		return wsdl;
	}

	@Bean
	public Resource customerServiceWsdl() {
		return new ClassPathResource("TrackingService.wsdl");
	}

	@Bean(name = { "com.demo.DataSource" })
	@ConfigurationProperties(prefix = "datasource.demo")
	@Primary
	public DataSource demoDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "demoDao")
	public DBConnector demoDao() {
		DBConnector obj = new DBConnector();
		obj.setDataSource(demoDataSource());
		try {
			obj.getJdbcTemplate().execute("SELECT NOW()");
		} catch (Exception e) {
			LOG.error(" Error while connecting to ConnectionManager.", e);
		}
		return obj;
	}
}
