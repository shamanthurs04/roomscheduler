package com.project.roomscheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@Entity(name = "room")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = SmallRoom.class, name = "SMALL"),
        @JsonSubTypes.Type(value = LargeRoom.class, name = "LARGE"),
        @JsonSubTypes.Type(value = MediumRoom.class, name = "MEDIUM")
})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public abstract class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    protected Long roomId;
    @Column(name="capacity")
    protected Integer capacity;

    @Column(name="floor")
    protected Integer floor;

    @Column(name="building")
    protected String building;

    @Column(name="staff_only")
    protected Boolean staffOnly;

    protected Room() {
    }

    public Room(Integer capacity, Integer floor, String building) {
        this.capacity = capacity;
        this.floor = floor;
        this.building = building;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Boolean getStaffOnly() {
        return staffOnly;
    }

    public void setStaffOnly(Boolean staffOnly) {
        this.staffOnly = staffOnly;
    }
}
