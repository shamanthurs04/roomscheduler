package com.project.roomscheduler.repository;

import com.project.roomscheduler.model.Feedback;
import com.project.roomscheduler.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class to handle all the CRUD Operations.
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


    @Query("SELECT f FROM feedback f ")
    List<Feedback> getAllFeedback();
}
