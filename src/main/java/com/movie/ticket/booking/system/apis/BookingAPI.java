package com.movie.ticket.booking.system.apis;

import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.services.BookingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
@Slf4j
public class BookingAPI {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingDTO createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
         System.out.println("Entered into booking API with JSON request"+bookingDTO);
        return bookingService.createBooking(bookingDTO);
    }
}
