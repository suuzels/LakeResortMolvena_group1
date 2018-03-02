package com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @PostConstruct
public void init(){
    Room r1 = new Room();
    r1.setRoomNumber(122);
    r1.setRoomName("Lakeview");
    r1.setDefaultPrice(89);
    r1.setRoomType(ERoomType.STANDARD);
    r1.setOccupied(false);

    this.roomRepository.save(r1);

    }
}
