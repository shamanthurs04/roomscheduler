package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

public class Snacks extends RoomAddons{
    public Snacks(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 10;
    }
}
