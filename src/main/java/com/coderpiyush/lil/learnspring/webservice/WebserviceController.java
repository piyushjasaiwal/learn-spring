package com.coderpiyush.lil.learnspring.webservice;

import com.coderpiyush.lil.learnspring.business.GuestService;
import com.coderpiyush.lil.learnspring.business.ReservationService;
import com.coderpiyush.lil.learnspring.business.RoomReservation;
import com.coderpiyush.lil.learnspring.data.Guest;
import com.coderpiyush.lil.learnspring.data.Room;
import com.coderpiyush.lil.learnspring.data.RoomRepository;
import com.coderpiyush.lil.learnspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final GuestService guestService;
    private final RoomRepository roomRepository;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService, RoomRepository roomRepository) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
        this.roomRepository = roomRepository;
    }

    @GetMapping(path = "/reservations")
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping(path = "/guests")
    public List<Guest> getGuests(){
        return this.guestService.getGuests();
    }

    @PostMapping(path = "/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) throws Exception {
        this.reservationService.addGuest(guest);
    }

    @GetMapping(path = "/rooms")
    public List<Room> getRooms(){
//        Iterable<Room> rooms = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        this.roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }
}
