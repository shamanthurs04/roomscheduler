package com.project.roomscheduler.controller;

import com.project.roomscheduler.enums.RoomType;
import com.project.roomscheduler.factory.RoomFactory;
import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for the CRUD api's of room.
 */
@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomFactory roomFactory;

    /**
     * Post API - To add/create a new room.
     * @param room
     * @param roomType
     * @return
     */
    @RequestMapping(value="/rooms/{roomType}", method= RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public Room createRoom(@RequestBody Room room,@PathVariable String roomType) {
        Room roomContext = roomFactory.getRoom(RoomType.valueOf(roomType.toUpperCase()), room);
        return roomService.createRoom(roomContext);
    }

    /**
     * Get API - To get a room details by id.
     * @param id
     * @return
     */
    @RequestMapping(value="/room/{id}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
}
