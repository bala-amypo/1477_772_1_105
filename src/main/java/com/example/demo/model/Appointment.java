package com.example.demo.entity;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private Visitor visitor;
    private Host host;
    private LocalDateTime appointmentTime;
    private String status;

    public Appointment() {
    }

    public Appointment(Long id, Visitor visitor, Host host,
                       LocalDateTime appointmentTime, String status) {
        this.id = id;
        this.visitor = visitor;
        this.host = host;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
