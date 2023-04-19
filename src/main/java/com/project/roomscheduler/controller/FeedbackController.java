package com.project.roomscheduler.controller;

import com.project.roomscheduler.model.Feedback;
import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value="/feedbacks", method= RequestMethod.POST)
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @RequestMapping(value="/feedbacks/{id}", method= RequestMethod.GET)
    public Feedback getFeedback(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }
}
