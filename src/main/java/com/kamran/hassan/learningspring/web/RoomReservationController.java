package com.kamran.hassan.learningspring.web;


import com.kamran.hassan.learningspring.business.ReservationService;
import com.kamran.hassan.learningspring.business.RoomReservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {
    private final ReservationService reservationService;

    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservation(@RequestParam(value = "date", required = false) String dateString, Model model){

        if (dateString != null) {
            List<RoomReservation> reservations = this.reservationService.getAllReservationDetailByDateString(dateString);
            model.addAttribute("roomReservation", reservations);
            return "roomres";   // will be get clear after some time
        }
        return null;
    }
}
