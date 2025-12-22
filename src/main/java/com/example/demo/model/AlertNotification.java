package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Visit log is required")
    @OneToOne
    @JoinColumn(name = "visit_log_id", unique = true)
    private VisitLog visitLog;

    @NotBlank(message = "Recipient email is required")
    @Email(message = "Invalid email format")
    private String sentTo;

    @NotBlank(message = "Alert message is required")
    private String alertMessage;

    private LocalDateTime sentAt;

    @PrePersist
    public void onSend() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public VisitLog getVisitLog() {
        return visitLog;
    }

    public void setVisitLog(VisitLog visitLog) {
        this.visitLog = visitLog;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
