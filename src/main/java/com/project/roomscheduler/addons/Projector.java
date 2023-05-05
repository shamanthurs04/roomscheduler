package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

//Decorator Design Pattern
//Concrete class Projector is an add-on provided to customer through decorator pattern
public class Projector extends RoomAddons{
    public Projector(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 8;
    }
}
