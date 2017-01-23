package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ws.config.annotation.EnableWs;


@Configuration
@ComponentScan(basePackages = {"com.demo", "com.demo.domain"})
@EnableWs
@SpringBootApplication
@EnableScheduling
public class TrackerappdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerappdemoApplication.class, args);
	}
}
