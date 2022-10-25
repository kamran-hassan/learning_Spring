package com.kamran.hassan.learningspring.util;

import com.kamran.hassan.learningspring.business.ReservationService;
import com.kamran.hassan.learningspring.business.RoomReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.kamran.hassan.learningspring.data.RoomRepository;
import com.kamran.hassan.learningspring.data.Room;

import com.kamran.hassan.learningspring.data.Guest;
import com.kamran.hassan.learningspring.data.GuestRepository;

import com.kamran.hassan.learningspring.data.Reservation;
import com.kamran.hassan.learningspring.data.ReservationRepo;

import java.util.ArrayList;
import java.util.Optional;

import java.text.SimpleDateFormat;
import java.util.Date;


// When Application is ready do the operation that what it means
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepo reservationRepo;
    private final ReservationService reservationService;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository,
                           ReservationRepo reservationRepo, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepo = reservationRepo;
        this.reservationService = reservationService;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        Iterable<Reservation> reservations = this.reservationRepo.findAll();
        reservations.forEach(System.out::println);

        System.out.println("----------Search using Id Primary Key----------");
        Optional<Reservation> reservationById = this.reservationRepo.findById((long)1);
        if(reservationById.isPresent()) System.out.println(reservationById); else System.out.println("No Data Found");

        System.out.println("--------Search using other data point like RoomId--------");
        Optional<Reservation> reservationByRoomId = this.reservationRepo.findByRoomId((long)8);   // As per business logic this can only return one value or nothing so optional is used to avoid null check
        if(reservationByRoomId.isPresent()) System.out.println(reservationByRoomId); else System.out.println("No Data Found");

        System.out.println("--------Search using Date value=-------");
        try {
            Iterable<Reservation> reservationByDate = this.reservationRepo.findByDate(new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01")); // may return list so Iterable is used
            reservationByDate.forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println("Date Format Exception");
        }

        System.out.println("----------Consuming Room Reservation Service---------");

        ArrayList<RoomReservation> AllReservationDetailByDate = this.reservationService.getAllReservationDetailByDateString("2022-01-01");

        if(AllReservationDetailByDate != null){
            AllReservationDetailByDate.forEach(System.out::println);
        }
        else System.out.println("No Data return By Reservation Service for given date");

    }
}
