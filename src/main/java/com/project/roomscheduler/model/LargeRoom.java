package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LARGE")
public class LargeRoom extends Room{
    public LargeRoom() {
    }

    public LargeRoom(Integer capacity, Integer floor, String building, Boolean staffOnly) {
        super(capacity, floor, building, staffOnly);
    }

}
