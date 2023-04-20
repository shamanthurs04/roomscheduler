package com.project.roomscheduler.addons;

import com.project.roomscheduler.model.Room;

public abstract class RoomAddons {
    private Room room;

    public RoomAddons(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room vehicle) {
        this.room = room;
    }

    public abstract int getAddonPrice(Room room);
}
