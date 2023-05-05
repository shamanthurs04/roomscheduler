package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
// Inheritance
public class Admin extends User{
    public Admin() {
    }

    public Admin(Long userId, String name, String email, Integer balance, String password, Boolean loggedIn) {
        super(userId, name, email, balance, password,loggedIn);
    }

}
