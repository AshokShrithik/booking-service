package com.movie.ticket.booking.system.repositories;

import com.movie.ticket.booking.system.entities.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {
}
