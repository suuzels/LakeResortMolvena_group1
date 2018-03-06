package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByRoomNumberContaining(String roomNumber);

    List<Room> findByIsOccupied(boolean isOccupied);
}
