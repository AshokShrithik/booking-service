package com.movie.ticket.booking.system.services;

import com.movie.ticket.booking.system.brokers.PaymentServiceBroker;
import com.movie.ticket.booking.system.dtos.BookingDTO;
import com.movie.ticket.booking.system.entities.BookingEntity;
import com.movie.ticket.booking.system.enums.BookingStatus;
import com.movie.ticket.booking.system.repositories.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentServiceBroker paymentService;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        log.info("entered into booking ervice impl" + bookingDTO);
        BookingEntity bookingEntity = BookingEntity.builder()
                .bookingAmount(bookingDTO.getBookingAmount())
                .seatsSelected(bookingDTO.getSeatsSelected())
                .bookingStatus(BookingStatus.PENDING)
                .movieId(bookingDTO.getMovieId())
                .userId(bookingDTO.getUserId())
                .showDate(bookingDTO.getShowDate())
                .showTime(bookingDTO.getShowTime())
                .build();
        this.bookingRepository.save(bookingEntity); // create a booking with booking status as PENDING
        bookingDTO.setBookingId(bookingEntity.getBookingId());
        bookingDTO.setBookingStatus(BookingStatus.PENDING);
try {
    String paymentResponse = paymentService.createPayment();
}
catch (Exception e){
    log.info(e.getMessage());
}

        return BookingDTO.builder()
                .bookingId(bookingEntity.getBookingId())
                .bookingAmount(bookingEntity.getBookingAmount())
                .bookingStatus(BookingStatus.CONFIRMED)
                .movieId(bookingEntity.getMovieId())
                .showTime(bookingEntity.getShowTime())
                .showDate(bookingEntity.getShowDate())
                .bookingAmount(bookingEntity.getBookingAmount())
                .userId(bookingEntity.getUserId())
                .seatsSelected(bookingEntity.getSeatsSelected())
                .build();
    }
}
