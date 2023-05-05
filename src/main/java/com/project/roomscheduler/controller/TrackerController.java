package com.project.roomscheduler.controller;

import com.project.roomscheduler.InitApplication;
import com.project.roomscheduler.observer.Tracker;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for the tracker API.
 */
@RestController
@RequestMapping("/api")
public class TrackerController {

    InitApplication init = InitApplication.getInstance();

    /**
     * Get api - to get the tracker details like number of rooms booked and money earned by addons.
     * @return
     */
    @RequestMapping(value="/tracker", method= RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public String getTrackerInfo() {
        Tracker tracker = Tracker.getInstance();
        org.json.JSONObject obj = new org.json.JSONObject();
        obj.put("rooms_booked", tracker.getRoomsBooked());
        obj.put("scheduler_earning", tracker.getSchedulerEarning());
        return obj.toString();
    }
}
