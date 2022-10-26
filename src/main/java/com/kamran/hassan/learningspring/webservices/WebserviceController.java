package com.kamran.hassan.learningspring.webservices;


import com.kamran.hassan.learningspring.business.ReservationService;
import com.kamran.hassan.learningspring.business.RoomReservation;
import com.kamran.hassan.learningspring.data.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final ReservationService reservationService;

    public WebserviceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ArrayList<RoomReservation> getReservations(@RequestParam(value = "date", required = true) String date){
        return this.reservationService.getAllReservationDetailByDateString(date);
    }
    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    public String addReservation(@RequestParam(value="lastname") String lastName, @RequestParam(value = "RoomNum") String roomNum, @RequestParam(value = "date") String date ){
        System.out.println(lastName+roomNum+date);
        this.reservationService.addReservationService(lastName, roomNum, date);
    return null;
    }

    @PostMapping("/addguest")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewGuest(@RequestBody Guest guest){
        System.out.println(guest);
        this.reservationService.addGuest(guest);
    }
}
