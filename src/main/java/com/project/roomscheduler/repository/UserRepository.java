package com.project.roomscheduler.repository;

import com.project.roomscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository class to handle all the CRUD Operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
