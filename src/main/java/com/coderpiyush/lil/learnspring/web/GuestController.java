package com.coderpiyush.lil.learnspring.web;

import com.coderpiyush.lil.learnspring.business.GuestService;
import com.coderpiyush.lil.learnspring.data.Guest;
import com.coderpiyush.lil.learnspring.data.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        List<Guest> guestList = guestService.getGuests();
        guestList.forEach(System.out::println);
        model.addAttribute("guestList", guestList);
        return "guests";
    }
}
