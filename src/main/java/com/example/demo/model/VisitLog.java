package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long visitorId;
    private long hostId;
    private String checkInTime;
    private String checkOutTime;
    private String purpose;
    private boolean accessGranted;

    public VisitLog() {
    }

    public VisitLog(long id, long visitorId, long hostId,
                    String checkInTime, String checkOutTime,
                    String purpose, boolean accessGranted) {
        this.id = id;
        this.visitorId = visitorId;
        this.hostId = hostId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.purpose = purpose;
        this.accessGranted = accessGranted;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getVisitorId() {
        return visitorId;
    }
    public void setVisitorId(long visitorId) {
        this.visitorId = visitorId;
    }

    public long getHostId() {
        return hostId;
    }
    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public String getCheckInTime() {
        return checkInTime;
    }
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean isAccessGranted() {
        return accessGranted;
    }
    public void setAccessGranted(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }
}
