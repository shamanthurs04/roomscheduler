package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

//Decorator Design Pattern
//Concrete class AirConditioner is an add-on provided to customer through decorator pattern
public class AirConditioner extends RoomAddons{
    public AirConditioner(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 15;
    }
}
