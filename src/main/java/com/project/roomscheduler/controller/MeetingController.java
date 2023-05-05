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

/**
 * Controller class for the CRUD api's of meeting.
 */
@RestController
@RequestMapping("/api")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @Autowired
    SchedulerManagementService schedulerService;

    InitApplication init = InitApplication.getInstance();

    /**
     * Post API - to create a meeting
     * @param meeting
     * @return
     */
    @RequestMapping(value="/meetings", method= RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        int addonPrice = schedulerService.updateAddons(meeting.getAddons(),meeting.getUserId(),meeting.getRoomId());
        Meeting response = meetingService.createMeeting(meeting);
        ObserverData data = init.createObserverData(1, (long) addonPrice);
        init.notifyObservers(data);
        return response;
    }

    /**
     * Get API - To get all the meetings for a give date.
     * @param date
     * @return
     */
    @RequestMapping(value="/meetings/{date}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Meeting> getMeetingsForDay(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return meetingService.findAllMeetingsOfDay(date);
    }

    /**
     * Get API - To get a meeting by id.
     * @param id
     * @return
     */
    @RequestMapping(value="/meeting/{id}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Meeting> getMeetingsForUser(@PathVariable Long id) {
        return meetingService.findAllMeetingsForUser(id);
    }

    /**
     * Get API - To get all the available rooms for the given date and time.
     * @param date
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value="/meetings/{date}/{start}/{end}", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Long> getAvailableRooms(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime start,
                                        @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime end) {
        return schedulerService.getAvailableRooms(date,start,end);
    }
}
