package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {



//
//
//
//    public ArrayList<Room> getRooms() {
//        return rooms;
//    }
//
//    public Room changeRoomType(Room room, ERoomType roomType) {
//        this.room.setRoomType(roomType);
//        return room;
//    }
//
//    public void deleteRoom() {
//        for (Room room : rooms) {
//            rooms.remove(room);
//        }
//    }
//
//    public void changeRoom(String roomID, ERoomType roomType) {
//        for (Room room : this.rooms) {
//            if (room.getRoomID() == roomID) {
//                room.setRoomType(roomType);
//            }
//        }
//
//    }
//
//    // Getters setters
//
//    public ArrayList<Room> getRoomList() {
//        return rooms;
//    }
//
//    public void setRoomList(ArrayList<Room> roomList) {
//        this.rooms = roomList;
//    }


}
