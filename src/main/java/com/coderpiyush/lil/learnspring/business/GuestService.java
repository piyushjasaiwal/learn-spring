package com.coderpiyush.lil.learnspring.business;

import com.coderpiyush.lil.learnspring.data.Guest;
import com.coderpiyush.lil.learnspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guestList::add);
        return guestList;
    }
}
