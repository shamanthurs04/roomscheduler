package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

public class Projector extends RoomAddons{
    public Projector(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 8;
    }
}
