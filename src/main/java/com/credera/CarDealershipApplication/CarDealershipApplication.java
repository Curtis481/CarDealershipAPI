package com.credera.CarDealershipApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication
public class CarDealershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("MountainStandardTime"));
	}
}
