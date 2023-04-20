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

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback getFeedbackById(Long feedback_id){
        return (Feedback) Hibernate.unproxy(feedbackRepository.getById(feedback_id));
    }
}
