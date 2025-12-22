package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Visitor is required")
    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @NotNull(message = "Host is required")
    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointmentDate;

    @NotBlank(message = "Purpose is required")
    private String purpose;

    @NotBlank
    private String status = "SCHEDULED";

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
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

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
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
