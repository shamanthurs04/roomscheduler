package com.project.roomscheduler.service;

import com.project.roomscheduler.addons.*;
import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.model.Room;
import com.project.roomscheduler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SchedulerManagementService {
    @Autowired
    RoomService roomService;
    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;

    public LinkedList<Long> getAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime){
        HashMap<Long,Room> allRooms = (HashMap<Long, Room>) roomService.getRooms().stream().collect(Collectors.toMap(Room::getRoomId, Function.identity()));
        LinkedList<Long> availableRoomIds = new LinkedList<>(allRooms.keySet());
        List<Meeting> meetingsForGiveDay =  meetingService.findAllMeetingsOfDay(date);
        for(Meeting meeting:meetingsForGiveDay){
            LocalTime targetStart = meeting.getStartTime();
            LocalTime targetEnd = meeting.getEndTime();
            //Check for both end Time and start Time if its overlapping interval
            Boolean isTargetAfterStartAndBeforeStop = targetEnd.isAfter(startTime) && targetStart.isBefore(endTime);
            //Remove room ID of overlapping meetings
            if(isTargetAfterStartAndBeforeStop)
                availableRoomIds.remove(meeting.getRoomId());
        }
        return availableRoomIds;
    }

    public void updateAddons(String addonList, long userId, long roomId){
        Room room = roomService.getRoomById(roomId);
        User user = userService.getUserById(userId);
        String[] addons = addonList.split(",");
        int addonPrice = 0;
        if (addons.length != 0) {
            for (String addon : addons) {
                RoomAddons roomAddon = getAddon(addon, room);
                addonPrice = roomAddon.getAddonPrice(room) + addonPrice;
            }
        }
        user.setBalance(user.getBalance()-addonPrice);
        userService.updateUser(userId,user);
    }

    private RoomAddons getAddon(String addon, Room room) {
        RoomAddons roomAddon = null;
        if (addon.equalsIgnoreCase("SNACKS")) {
            roomAddon = new Snacks(room);
        } else if (addon.equalsIgnoreCase("BEVERAGES")) {
            roomAddon = new Beverages(room);
        } else if (addon.equalsIgnoreCase("AIR_CONDITIONER")) {
            roomAddon = new AirConditioner(room);
        } else if (addon.equalsIgnoreCase("PROJECTOR")) {
            roomAddon = new Projector(room);
        }
        return roomAddon;
    }
}
