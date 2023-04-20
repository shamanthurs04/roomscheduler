package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

public class AirConditioner extends RoomAddons{
    public AirConditioner(Room room) {
        super(room);
    }

    @Override
    public int getAddonPrice(Room room) {
        return 15;
    }
}
