package com.project.roomscheduler.factory;

import com.project.roomscheduler.enums.UserType;
import com.project.roomscheduler.model.*;
import org.springframework.stereotype.Component;

//COHESION:
//UserFactory Class exhibits high cohesion
//It performs and is associated with a single purpose, create and add users

//Factory Pattern
@Component
public class UserFactory {
    public User getUser(UserType userType, User user) {
        if (userType == null) {
            return null;
        }
        if (userType == UserType.ADMIN) {
            return new Admin(user.getUserId(),user.getName(),user.getEmail(),user.getBalance(),user.getPassword(),user.getLoggedIn());
        } else if (userType == UserType.STAFF) {
            return new Staff(user.getUserId(),user.getName(),user.getEmail(),user.getBalance(),user.getPassword(),user.getLoggedIn());
        } else if (userType == UserType.STUDENT) {
            return new Student(user.getUserId(),user.getName(),user.getEmail(),user.getBalance(),user.getPassword(),user.getLoggedIn());
        }
        return null;
    }
}
