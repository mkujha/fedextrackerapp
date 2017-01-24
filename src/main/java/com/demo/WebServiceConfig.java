package com.demo;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.demo.client.SwatchdaylightClient;
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
		marshaller.setContextPaths("com.demo.fedex.domain", "com.demo.swatchdaylight.reach4mobile");
		// marshaller.setPackagesToScan("");
		return marshaller;
	}

	@Bean
	public FedexTrackerClient fexExClient(Jaxb2Marshaller jaxb2Marshaller) {
		FedexTrackerClient client = new FedexTrackerClient();
		client.setDefaultUri("https://wsbeta.fedex.com:443/web-services/track");
		client.setMarshaller(jaxb2Marshaller);
		client.setUnmarshaller(jaxb2Marshaller);
		return client;
	}

	@Bean
	public SwatchdaylightClient swatchdaylightClient(Jaxb2Marshaller jaxb2Marshaller) {
		SwatchdaylightClient client = new SwatchdaylightClient();
		client.setDefaultUri(
				"http://swatchdaylight.reach4mobile.com:8080/axis2/services/CtModestoWsaWsSwatch.CtModestoWsaWsSwatchHttpSoap12Endpoint/");
		client.setMarshaller(jaxb2Marshaller);
		client.setUnmarshaller(jaxb2Marshaller);
		return client;
	}

	@Bean("SwatchdaylightService")
	public SimpleWsdl11Definition definition1509() {
		SimpleWsdl11Definition wsdl = new SimpleWsdl11Definition();
		wsdl.setWsdl(swatchdaylightServiceWsdl());
		return wsdl;
	}

	@Bean
	public Resource swatchdaylightServiceWsdl() {
		return new ClassPathResource("CtModestoWsaWsSwatch.wsdl");
	}

	@Bean("TrackingDetailsService")
	public SimpleWsdl11Definition definitionFexEx() {
		SimpleWsdl11Definition wsdl = new SimpleWsdl11Definition();
		wsdl.setWsdl(fedExServiceWsdl());
		return wsdl;
	}

	@Bean
	public Resource fedExServiceWsdl() {
		return new ClassPathResource("TrackingDetailsService.wsdl");
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
