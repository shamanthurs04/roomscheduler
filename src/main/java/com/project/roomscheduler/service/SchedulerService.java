package com.project.roomscheduler.service;

import com.project.roomscheduler.model.Meeting;
import com.project.roomscheduler.model.Room;
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
public class SchedulerService {
    @Autowired
    RoomService roomService;
    @Autowired
    MeetingService meetingService;

    public LinkedList<Long> getAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime){
        HashMap<Long,Room> allRooms = (HashMap<Long, Room>) roomService.getRooms().stream().collect(Collectors.toMap(Room::getRoomId, Function.identity()));
        LinkedList<Long> availableRoomIds = new LinkedList<>(allRooms.keySet());
        List<Meeting> meetingsForGiveDay =  meetingService.findAllMeetingsOfDay(date);
        for(Meeting meeting:meetingsForGiveDay){
            LocalTime target = meeting.getStartTime();
            Boolean isTargetAfterStartAndBeforeStop = ( target.isAfter( startTime ) && target.isBefore( endTime ) ) ;
            if(isTargetAfterStartAndBeforeStop)
                availableRoomIds.remove(meeting.getMeetingId());
        }
        return availableRoomIds;
    }
}
