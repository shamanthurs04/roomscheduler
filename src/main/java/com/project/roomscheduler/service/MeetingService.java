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

    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public List<Meeting> findAllMeetingsOfDay(LocalDate date){
        return meetingRepository.findAllMeetingsForGivenDay(date);
    }
}
