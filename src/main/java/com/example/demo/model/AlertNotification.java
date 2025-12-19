package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long visitLogId;
    private String message;
    private String sentTo;
    private String sentTime;

    public AlertNotification() {
    }

    public AlertNotification(long id, long visitLogId,
                             String message, String sentTo, String sentTime) {
        this.id = id;
        this.visitLogId = visitLogId;
        this.message = message;
        this.sentTo = sentTo;
        this.sentTime = sentTime;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getVisitLogId() {
        return visitLogId;
    }
    public void setVisitLogId(long visitLogId) {
        this.visitLogId = visitLogId;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentTo() {
        return sentTo;
    }
    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSentTime() {
        return sentTime;
    }
    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }
}
