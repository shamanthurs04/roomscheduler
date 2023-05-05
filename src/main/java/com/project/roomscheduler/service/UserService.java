package com.project.roomscheduler.service;

import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.model.User;
import com.project.roomscheduler.repository.RoomRepository;
import com.project.roomscheduler.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Method to create a user
     * @param user
     * @return
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Method to get user by id.
     * @param userId
     * @return
     */
    public User getUserById(Long userId){
        return (User) Hibernate.unproxy(userRepository.getById(userId));
    }

    /**
     * Method to get all the users.
     * @return
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Method to delete a user.
     * @param roomId
     */
    public void deleteUser(Long roomId) {
        userRepository.deleteById(roomId);
    }

    /**
     * Method to update a user.
     * @param userId
     * @param userDetails
     * @return
     */
    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).get();
        user.setName(userDetails.getName());
        user.setBalance(userDetails.getBalance());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }
}
