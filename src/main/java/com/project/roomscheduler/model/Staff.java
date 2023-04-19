package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STAFF")
public class Staff extends User{
    public Staff() {
    }

    public Staff(Long userId, String name, String email, Integer balance, String password) {
        super(userId, name, email, balance, password);
    }

}
