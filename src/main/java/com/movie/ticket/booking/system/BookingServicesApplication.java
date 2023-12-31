package com.movie.ticket.booking.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServicesApplication.class, args);
	}

}
