package com.project.roomscheduler.factory;

import com.project.roomscheduler.enums.RoomType;
import com.project.roomscheduler.model.LargeRoom;
import com.project.roomscheduler.model.MediumRoom;
import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.model.SmallRoom;
import org.springframework.stereotype.Component;

//COHESION:
//RoomFactory Class exhibits high cohesion
//It performs and is associated with a single purpose, create and add rooms

//Factory Pattern
@Component
public class RoomFactory {

    public Room getRoom(RoomType roomType, Room room) {
        if (roomType == null) {
            return null;
        }
        if (roomType == RoomType.SMALL) {
            return new SmallRoom(room.getCapacity(),room.getFloor(),room.getBuilding(),room.getStaffOnly());
        } else if (roomType == RoomType.MEDIUM) {
            return new MediumRoom(room.getCapacity(),room.getFloor(),room.getBuilding(),room.getStaffOnly());
        } else if (roomType == RoomType.LARGE) {
            return new LargeRoom(room.getCapacity(),room.getFloor(),room.getBuilding(),room.getStaffOnly());
        }
        return null;
    }
}
