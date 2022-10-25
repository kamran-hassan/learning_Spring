package com.kamran.hassan.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Date;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long> {
    Optional<Reservation> findByRoomId(long roomId);
    Iterable<Reservation> findByDate(Date date);
    Optional<Reservation> findByGuestId(long guestId);
}
