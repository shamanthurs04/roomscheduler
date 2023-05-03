package com.project.roomscheduler.service;

import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeetingService {
    @Autowired
    MeetingRepository meetingRepository;

    /**
     * Method to create a meeting.
     * @param meeting
     * @return
     */
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    /**
     * Method to find all meetings of given date
     * @param date
     * @return
     */
    public List<Meeting> findAllMeetingsOfDay(LocalDate date){
        return meetingRepository.findAllMeetingsForGivenDay(date);
    }

    /**
     * Method to find all meetings booked by given user id.
     * @param id
     * @return
     */
    public List<Meeting> findAllMeetingsForUser(Long id) {
        return meetingRepository.findAllMeetingsForGivenUser(id);
    }
}
