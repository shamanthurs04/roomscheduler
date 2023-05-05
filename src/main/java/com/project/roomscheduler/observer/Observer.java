package com.project.roomscheduler.observer;


//Observer Pattern - Observer Interface
//Declaration of the push method to send observer data
public interface Observer {
    /**
     * Method to push data to the observer
     * @param observerData
     */
    public void push(ObserverData observerData);
}
