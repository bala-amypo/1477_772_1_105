package com.example.demo.entity;

public class AlertNotification {

    private Long id;
    private String message;
    private boolean sent;

    public AlertNotification() {
    }

    public AlertNotification(Long id, String message, boolean sent) {
        this.id = id;
        this.message = message;
        this.sent = sent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
