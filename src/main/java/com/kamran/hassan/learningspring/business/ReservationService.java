package com.kamran.hassan.learningspring.business;


import com.kamran.hassan.learningspring.data.GuestRepository;
import com.kamran.hassan.learningspring.data.ReservationRepo;
import com.kamran.hassan.learningspring.data.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final ReservationRepo reservationRepo;
    private final GuestRepository guestRepository;

    public ReservationService(RoomRepository roomRepository, ReservationRepo reservationRepo, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepo = reservationRepo;
        this.guestRepository = guestRepository;
    }



}
