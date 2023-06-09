package com.project.roomscheduler.controller;

import com.project.roomscheduler.model.Feedback;
import com.project.roomscheduler.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the CRUD api's of feedback.
 */
@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    /**
     * API to add the feedback for a meeting.
     * @param feedback
     * @return
     */
    @RequestMapping(value="/feedbacks", method= RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    /**
     * Get API - To get the feedback based on the id.
     * @param id
     * @return
     */
    @RequestMapping(value="/feedbacks/{id}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public Feedback getFeedback(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    /**
     * Get api - get all the feedbacks
     * @return
     */
    @RequestMapping(value="/allFeedbacks", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}
