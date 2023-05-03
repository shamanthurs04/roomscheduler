package com.project.roomscheduler.controller;

import com.project.roomscheduler.InitApplication;
import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.observer.ObserverData;
import com.project.roomscheduler.service.MeetingService;
import com.project.roomscheduler.service.SchedulerManagementService;
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
    SchedulerManagementService schedulerService;

    InitApplication init = InitApplication.getInstance();

    @RequestMapping(value="/meetings", method= RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        int addonPrice = schedulerService.updateAddons(meeting.getAddons(),meeting.getUserId(),meeting.getRoomId());
        Meeting response = meetingService.createMeeting(meeting);
        ObserverData data = init.createObserverData(1, (long) addonPrice);
        init.notifyObservers(data);
        return response;
    }

    @RequestMapping(value="/meetings/{date}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Meeting> getMeetingsForDay(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return meetingService.findAllMeetingsOfDay(date);
    }

    @RequestMapping(value="/meeting/{id}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Meeting> getMeetingsForUser(@PathVariable Long id) {
        return meetingService.findAllMeetingsForUser(id);
    }

    @RequestMapping(value="/meetings/{date}/{start}/{end}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Long> getAvailableRooms(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime start,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime end) {
        return schedulerService.getAvailableRooms(date,start,end);
    }
}
