package com.project.roomscheduler.controller;

import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.service.MeetingService;
import com.project.roomscheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @Autowired
    SchedulerService schedulerService;

    @RequestMapping(value="/meetings", method= RequestMethod.POST)
    public Meeting createRoom(@RequestBody Meeting meeting) {
        return meetingService.createMeeting(meeting);
    }

    @RequestMapping(value="/meetings/{date}", method= RequestMethod.GET)
    public List<Meeting> getMeetingsForDay(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return meetingService.findAllMeetingsOfDay(date);
    }

    @RequestMapping(value="/meetings/{date}/{start}/{end}", method= RequestMethod.GET)
    public List<Long> getAvailableRooms(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime start,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime end) {
        return schedulerService.getAvailableRooms(date,start,end);
    }
}
