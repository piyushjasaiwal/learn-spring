package com.coderpiyush.lil.learnspring.util;

import java.util.Date;
import java.util.List;

import com.coderpiyush.lil.learnspring.business.ReservationService;
import com.coderpiyush.lil.learnspring.business.RoomReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
//public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
//    private final RoomRepository roomRepository;
//    private final ReservationRepository reservationRepository;
//    private final GuestRepository guestRepository;
//
//    public AppStartupEvent(RoomRepository roomRepository, ReservationRepository reservationRepository, GuestRepository guestRepository) {
//        this.roomRepository = roomRepository;
//        this.reservationRepository = reservationRepository;
//        this.guestRepository = guestRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Iterable<Room> rooms = this.roomRepository.findAll();
//        rooms.forEach(System.out::println);
//        Iterable<Guest> guests = this.guestRepository.findAll();
//        guests.forEach(System.out::println);
//        Iterable<Reservation> reservations = this.reservationRepository.findAll();
//        reservations.forEach(System.out::println);
//    }
//}


@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
//    @Autowired
    private final ReservationService reservationService;
//    @Autowired
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
//        reservations.forEach(System.out::println);
    }
}