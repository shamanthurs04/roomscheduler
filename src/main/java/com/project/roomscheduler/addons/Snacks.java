package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

//Decorator Design Pattern
//Concrete class Snacks is an add-on provided to customer through decorator pattern
public class Snacks extends RoomAddons{
    public Snacks(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 10;
    }
}
