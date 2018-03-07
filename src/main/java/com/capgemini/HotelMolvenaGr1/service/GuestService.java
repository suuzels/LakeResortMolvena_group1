package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class GuestService {

    @Autowired
    private IGuestRepository guestRepository;

    public Guest findById(long id){return this.guestRepository.findOne(id);}

    public Iterable<Guest> findAll(){return this.guestRepository.findAll();}

    @PostConstruct
    public void init(){
        Guest g1 = new Guest();
        g1.setFirstName("Jan");
        g1.setLastName("Jansen");

        Guest g2 = new Guest();
        g2.setFirstName("Henk");
        g2.setLastName("Henkstra");

        this.guestRepository.save(g1);
        this.guestRepository.save(g2);

    }
}
