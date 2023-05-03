package com.project.roomscheduler.service;

import com.project.roomscheduler.model.Feedback;
import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.repository.FeedbackRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService{
    @Autowired
    FeedbackRepository feedbackRepository;

    /**
     * Method to create a feedback.
     * @param feedback
     * @return
     */
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    /**
     * Method to get feedback by id.
     * @param feedback_id
     * @return
     */
    public Feedback getFeedbackById(Long feedback_id){
        return (Feedback) Hibernate.unproxy(feedbackRepository.getById(feedback_id));
    }

    /**
     * Method to get all feedbacks
     * @return
     */
    public List<Feedback> getAllFeedback() {
        return (List<Feedback>) Hibernate.unproxy(feedbackRepository.getAllFeedback());
    }
}
