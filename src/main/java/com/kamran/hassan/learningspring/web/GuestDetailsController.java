package com.kamran.hassan.learningspring.web;


import com.kamran.hassan.learningspring.data.Guest;
import com.kamran.hassan.learningspring.data.GuestRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestDetailsController {
    private final GuestRepository guestRepository;

    public GuestDetailsController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String getAllGuestDetails(Model model){
        Iterable<Guest> guests = this.guestRepository.findAll();
        model.addAttribute("guestDetails", guests);
        return "guestdetails";
    }
}
