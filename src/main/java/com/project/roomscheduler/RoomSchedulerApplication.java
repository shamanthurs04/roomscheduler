package com.project.roomscheduler;

import com.project.roomscheduler.observer.Tracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomSchedulerApplication{
	public static void main(String[] args) {
		Tracker tracker = Tracker.getInstance();
		InitApplication init = InitApplication.getInstance();
		init.registerObserver(tracker);
		SpringApplication.run(RoomSchedulerApplication.class, args);
	}
}
