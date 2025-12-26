package com.example.demo.entity;

import java.time.LocalDateTime;

public class VisitLog {

    private Long id;
    private Visitor visitor;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public VisitLog() {
    }

    public VisitLog(Long id, Visitor visitor,
                    LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        this.id = id;
        this.visitor = visitor;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
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

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
