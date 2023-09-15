package com.coderpiyush.lil.learnspring.web;

import com.coderpiyush.lil.learnspring.business.ReservationService;
import com.coderpiyush.lil.learnspring.business.RoomReservation;
import com.coderpiyush.lil.learnspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        //print something over here
        System.out.println("something");
        System.out.println(date);
        roomReservations.forEach(System.out::println);
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }
}
