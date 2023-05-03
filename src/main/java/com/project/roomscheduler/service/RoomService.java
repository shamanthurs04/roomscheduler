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

    // CREATE a new room
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    /**
     * Method to get room by id.
     * @param roomId
     * @return
     */
    public Room getRoomById(Long roomId){
        return (Room)Hibernate.unproxy(roomRepository.getById(roomId));
    }

    /**
     * Method to get all rooms.
     * @return
     */
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    /**
     * Method to delete a room
     * @param roomId
     */
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    /**
     * Method to update a room.
     * @param roomId
     * @param roomDetails
     * @return
     */
    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = roomRepository.findById(roomId).get();
        room.setCapacity(roomDetails.getCapacity());
        room.setFloor(roomDetails.getFloor());
        room.setBuilding(roomDetails.getBuilding());
        return roomRepository.save(room);
    }

}
