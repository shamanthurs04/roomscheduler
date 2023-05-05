package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

//Decorator Design Pattern
//Concrete class Beverages is an add-on provided to customer through decorator pattern
public class Beverages extends RoomAddons{
    public Beverages(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 5;
    }
}
