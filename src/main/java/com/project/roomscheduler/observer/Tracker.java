package com.project.roomscheduler.observer;

//Observer Pattern
//Implementation of Tracker(Observer pattern)
//Keeps track of present day earning of Staff, fncd.FNCD and announces it each day

//Singleton Pattern
//Lazy Instantiation
public class Tracker implements Observer {
    private int roomsBooked;
    private long schedulerEarning;
    int n;

    private static Tracker instance = null;

    public static Tracker getInstance()
    {
        //We have used lazy method to create the singleton object here
        if(instance == null)
            instance = new Tracker();
        return instance;
    }

    public void setTrackerDay(int n){
        this.n = n;
    }
    public void clearTracker(){
        this.roomsBooked = 0;
        this.schedulerEarning = 0;
        this.n = 0;
    }

    /**
     * Sets and adds staff Earning and FNCD Earning
     * @param observerData
     */
    @Override
    public void push(ObserverData observerData) {
        if (observerData.roomsBooked != null) {
            this.roomsBooked += observerData.roomsBooked;
        }
        if (observerData.schedulerEarning != null) {
            this.schedulerEarning += observerData.schedulerEarning;
        }
    }

    /**
     * Displays the tracker data - Staff Earning, FNCD Earning
     */
    public void display() {
        System.out.println("Tracker: Day "+ n);
        System.out.println("Total rooms booked for the day:" + roomsBooked);
        System.out.println("Total money earned by the bookings: $" + schedulerEarning);
    }

    public int getRoomsBooked() {
        return roomsBooked;
    }

    public long getSchedulerEarning() {
        return schedulerEarning;
    }
}
