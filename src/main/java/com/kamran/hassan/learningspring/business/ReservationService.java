package com.kamran.hassan.learningspring.business;


import com.kamran.hassan.learningspring.data.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

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

    public ArrayList<RoomReservation> getAllReservationDetailByDateString(String date) {
        ArrayList<RoomReservation> roomReservations = new ArrayList<>();
        try {
            Iterable<Reservation> reservationByDate = this.reservationRepo.findByDate(new SimpleDateFormat("yyyy-mm-dd").parse(date)); // may return list so Iterable is used
            for(Reservation reserv : reservationByDate){
                Optional<Guest> g = this.guestRepository.findById(reserv.getGuestId());
                Optional<Room> r = this.roomRepository.findById(reserv.getRoomId());
                RoomReservation roomReservation = new RoomReservation();
                roomReservation.setRoomId(r.get().getId());
                roomReservation.setGuestId(g.get().getId());
                roomReservation.setFirstName(g.get().getFirstName());
                roomReservation.setLastName(g.get().getLastName());
                roomReservation.setDate(reserv.getDate());
                roomReservation.setRoomNumber(r.get().getRoomNumber());
                roomReservation.setRoomName(r.get().getName());

                roomReservations.add(roomReservation);

            }
        }
        catch (Exception e){
            System.out.println("error =>"+e.getMessage());
        }

        return roomReservations;
    }



}
