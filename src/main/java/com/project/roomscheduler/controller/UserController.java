package com.project.roomscheduler.controller;

import com.project.roomscheduler.enums.UserType;
import com.project.roomscheduler.factory.UserFactory;
import com.project.roomscheduler.model.*;
import com.project.roomscheduler.service.RoomService;
import com.project.roomscheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserFactory userFactory;
    @RequestMapping(value="/user/{userType}", method= RequestMethod.POST)
    public User createUser(@RequestBody User user, @PathVariable String userType) {
        User userContext = userFactory.getUser(UserType.valueOf(userType.toUpperCase()),user);
        return userService.createUser(userContext);
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
