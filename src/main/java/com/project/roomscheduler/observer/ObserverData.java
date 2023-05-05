package com.project.roomscheduler.observer;

//ObserverData class to help create observer data for tracking
public class ObserverData {
    public Integer roomsBooked;
    public Long schedulerEarning;

    public ObserverData(Integer roomsBooked, Long schedulerEarning) {
        this.roomsBooked = roomsBooked;
        this.schedulerEarning = schedulerEarning;
    }
}
