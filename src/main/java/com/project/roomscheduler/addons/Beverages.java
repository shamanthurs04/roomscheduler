package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

public class Beverages extends RoomAddons{
    public Beverages(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 5;
    }
}
