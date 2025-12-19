package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long visitorId;
    private long hostId;
    private String appointmentDate;
    private String purpose;
    private String status;

    public Appointment() {
    }

    public Appointment(long id, long visitorId, long hostId,
                       String appointmentDate, String purpose, String status) {
        this.id = id;
        this.visitorId = visitorId;
        this.hostId = hostId;
        this.appointmentDate = appointmentDate;
        this.purpose = purpose;
        this.status = status;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
