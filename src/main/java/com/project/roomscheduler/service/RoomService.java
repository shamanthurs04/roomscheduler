package com.project.roomscheduler.service;

import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.repository.RoomRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    // CREATE
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long roomId){
        return (Room)Hibernate.unproxy(roomRepository.getById(roomId));
    }

    // READ
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    // DELETE
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    // UPDATE
    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = roomRepository.findById(roomId).get();
        room.setCapacity(roomDetails.getCapacity());
        room.setFloor(roomDetails.getFloor());
        room.setBuilding(roomDetails.getBuilding());
        return roomRepository.save(room);
    }

}
