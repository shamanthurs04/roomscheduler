package com.project.roomscheduler.observer;

//Observer Pattern
//Subject interface having general functions to register, unregister and notify observers
public interface Subject {
    /**
     * Method to register observers
     * @param o
     */
    public void registerObserver(Observer o);
    /**
     * Method to deregister observers
     * @param o
     */
    public void unregisterObserver(Observer o);
    /**
     * Method to notify observers
     * @param data
     */
    public void notifyObservers(ObserverData data);
}
