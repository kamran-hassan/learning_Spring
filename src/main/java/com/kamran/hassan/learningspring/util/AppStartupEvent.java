package com.kamran.hassan.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.kamran.hassan.learningspring.data.RoomRepository;
import com.kamran.hassan.learningspring.data.Room;

import com.kamran.hassan.learningspring.data.Guest;
import com.kamran.hassan.learningspring.data.GuestRepository;

import com.kamran.hassan.learningspring.data.Reservation;
import com.kamran.hassan.learningspring.data.ReservationRepo;

import java.util.Optional;

import java.text.SimpleDateFormat;
import java.util.Date;


// When Application is ready do the operation that what it means
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepo reservationRepo;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepo reservationRepo) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepo = reservationRepo;

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
        Optional<Reservation> reservationByRoomId = this.reservationRepo.findByRoomId((long)8);
        if(reservationByRoomId.isPresent()) System.out.println(reservationByRoomId); else System.out.println("No Data Found");

        System.out.println("--------Search using Date value=-------");
        try {
            Iterable<Reservation> reservationByDate = this.reservationRepo.findByDate(new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01"));
            reservationByDate.forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println("Date Format Exception");
        }


    }
}
