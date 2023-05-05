package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEDIUM")
public class MediumRoom extends Room{
    public MediumRoom() {
    }

    public MediumRoom(Integer capacity, Integer floor, String building, Boolean staffOnly) {
        super(capacity, floor, building, staffOnly);
    }

}
