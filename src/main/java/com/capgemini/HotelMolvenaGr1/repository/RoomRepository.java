package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.ERoomType;
import com.capgemini.HotelMolvenaGr1.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RoomRepository {

    private Room room;

    // List of rooms

    ArrayList<Room> rooms;

    public RoomRepository() {
        this.rooms = new ArrayList<>();

        Room room1 = new Room();
        room1.setRoomType(ERoomType.STANDARD);
        room1.setAvailable(true);
        room1.setRoomID("1");
        room1.setDefaultPrice(89);
        room1.setRoomName("Iron Man");

        Room room2 = new Room();
        room2.setRoomType(ERoomType.LUXURY);
        room2.setAvailable(true);
        room2.setRoomID("2");
        room2.setDefaultPrice(149);
        room2.setRoomName("Black Panther");

        Room room3 = new Room();
        room3.setRoomType(ERoomType.HONEYMOON_SUITE);
        room3.setAvailable(true);
        room3.setRoomID("3");
        room3.setDefaultPrice(345);
        room3.setRoomName("Hulk");

        this.rooms.add(room1);
        this.rooms.add(room2);
        this.rooms.add(room3);


    }

    // Methodes
    public Room save(Room room) {
        rooms.add(room);
        return room;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room changeRoomType(Room room, ERoomType roomType) {
        this.room.setRoomType(roomType);
        return room;
    }

    public void deleteRoom(String roomID) {
        for (Room room : this.rooms) {
            if (room.getRoomID() == roomID) {
                rooms.remove(room);
            }
        }
    }

    public void changeRoom(String roomID, ERoomType roomType) {
        for (Room room : this.rooms) {
            if (room.getRoomID() == roomID) {
                room.setRoomType(roomType);
            }
        }

    }

    // Getters setters

    public ArrayList<Room> getRoomList() {
        return rooms;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.rooms = roomList;
    }


}
