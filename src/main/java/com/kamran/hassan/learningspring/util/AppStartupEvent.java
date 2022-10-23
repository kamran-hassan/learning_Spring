package com.kamran.hassan.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.kamran.hassan.learningspring.data.RoomRepository;
import com.kamran.hassan.learningspring.data.Room;

import com.kamran.hassan.learningspring.data.Guest;
import com.kamran.hassan.learningspring.data.GuestRepository;


// When Application is ready do the operation that what it means
@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);
    }
}
