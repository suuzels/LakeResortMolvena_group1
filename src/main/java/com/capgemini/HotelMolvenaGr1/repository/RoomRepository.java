package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Iterable<Room> findByRoomNumberContaining(String roomNumber);

    Iterable<Room> findByRoomNameContainingIgnoreCase(String roomName);

    Iterable<Room> findByIsOccupied(boolean isOccupied);
}
