package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import com.capgemini.HotelMolvenaGr1.repository.IGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GuestServices {

    @Autowired
    private IGuestRepository guestRepository;

    public Guest findById(long id){return this.guestRepository.findOne(id);}

    public Iterable<Guest> findAll(){return this.guestRepository.findAll();}


}
