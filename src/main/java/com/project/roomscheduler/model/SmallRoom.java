package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SMALL")
public class SmallRoom extends Room{
    public SmallRoom() {
    }

    public SmallRoom(Integer capacity, Integer floor, String building, Boolean staffOnly) {
        super(capacity, floor, building, staffOnly);
    }

}
