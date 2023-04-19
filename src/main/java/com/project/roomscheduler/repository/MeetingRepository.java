package com.project.roomscheduler.repository;

import com.project.roomscheduler.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    @Query("SELECT m FROM meeting m WHERE m.date = :date")
    List<Meeting> findAllMeetingsForGivenDay(LocalDate date);
}
