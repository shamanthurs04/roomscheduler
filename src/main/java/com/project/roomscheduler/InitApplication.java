package com.project.roomscheduler;

import com.project.roomscheduler.observer.Observer;
import com.project.roomscheduler.observer.ObserverData;
import com.project.roomscheduler.observer.Subject;
import com.project.roomscheduler.observer.Tracker;

import java.util.LinkedList;

public class InitApplication implements Subject {
    private LinkedList<Observer> observerList = new LinkedList<>();
    private static InitApplication instance = null;

    public static InitApplication getInstance()
    {
        //We have used lazy method to create the singleton object here
        if(instance == null)
            instance = new InitApplication();
        return instance;
    }
    /**
     * Method to register observers
     *
     * @param o
     */
    // Polymorphism
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * Method to deregister observers
     *
     * @param o
     */
    // Polymorphism
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(o);
    }

    /**
     * Method to notify observers
     *
     * @param data
     */
    // Polymorphism
    @Override
    public void notifyObservers(ObserverData data) {
        observerList.forEach(observer -> {
            observer.push(data);
        });
    }

    public ObserverData createObserverData(Integer roomsBooked, Long schedulerEarning) {
        return new ObserverData(roomsBooked, schedulerEarning);
    }
}
