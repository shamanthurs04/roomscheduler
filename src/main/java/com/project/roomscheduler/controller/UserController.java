package com.project.roomscheduler.controller;

import com.project.roomscheduler.enums.Status;
import com.project.roomscheduler.enums.UserType;
import com.project.roomscheduler.factory.UserFactory;
import com.project.roomscheduler.model.*;
import com.project.roomscheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the CRUD api's of User.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserFactory userFactory;

    /**
     * Post API - to add/create a new user.
     * @param user
     * @param userType
     * @return
     */
    @RequestMapping(value="/users/{userType}", method= RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public User createUser(@RequestBody User user, @PathVariable String userType) {
        User userContext = userFactory.getUser(UserType.valueOf(userType.toUpperCase()),user);
        return userService.createUser(userContext);
    }

    /**
     * Get API - To get a user details by id.
     * @param id
     * @return
     */
    @RequestMapping(value="/users/{id}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * To register a user
     * @param newUser
     * @return
     */
    @PostMapping(value = "/users/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public Status registerUser(@RequestBody User newUser) {
        List<User> users = userService.getAllUsers();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.getEmail().equals(newUser.getEmail())) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        User createdUser = userService.createUser(newUser);
        return Status.SUCCESS;
    }

    /**
     * To login a user into the system.
     * @param loginRequest
     * @return
     */
    @PostMapping("/users/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public Long loginUser(@RequestBody LoginRequest loginRequest) {
        List<User> users = userService.getAllUsers();
        for (User other : users) {
            if (other.getEmail().equals(loginRequest.getEmail()) && other.getPassword().equals(loginRequest.getPassword())) {
                other.setLoggedIn(true);
                userService.updateUser(other.getUserId(),other);
                //Return User ID of the user
                return other.getUserId();
            }
        }
        //Return 0 indicating login failed
        return 0L;
    }

    /**
     * To logout the user of the system.
     * @param logoutRequest
     * @return
     */
    @PostMapping("/users/logout")
    @CrossOrigin(origins = "http://localhost:3000")
    public Status logUserOut(@RequestBody LogoutRequest logoutRequest) {
        List<User> users = userService.getAllUsers();
        for (User other : users) {
            if (other.getEmail().equals(logoutRequest.getEmail()) && other.getLoggedIn() == true) {
                other.setLoggedIn(false);
                userService.updateUser(other.getUserId(),other);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

}
