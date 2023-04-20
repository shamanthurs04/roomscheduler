package com.project.roomscheduler.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User{
    public Student() {
    }

    public Student(Long userId, String name, String email, Integer balance, String password) {
        super(userId, name, email, balance, password);
    }

}
