package com.project.roomscheduler.model;

import javax.persistence.*;

@Entity(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedback_id")
    // Encapsulation
    private Long feedback_id;
    @Column(name="feedback")
    // Encapsulation
    private String feedback;
    @Column(name="rating")
    // Encapsulation
    private Integer rating;

    @Column(name="meeting_id")
    // Encapsulation
    private Long meeting_id;

    public Long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Long meeting_id) {
        this.meeting_id = meeting_id;
    }
}
