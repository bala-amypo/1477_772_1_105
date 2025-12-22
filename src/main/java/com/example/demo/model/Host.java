package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String hostName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String department;

    @NotBlank
    private String phone;

    @OneToMany(mappedBy = "host")
    @JsonIgnore
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "host")
    @JsonIgnore
    private List<VisitLog> visitLogs;

   

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getHostName() {
        return hostName;
    }
 
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getDepartment() {
        return department;
    }
 
    public void setDepartment(String department) {
        this.department = department;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public List<Appointment> getAppointments() {
        return appointments;
    }
 
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
 
    public List<VisitLog> getVisitLogs() {
        return visitLogs;
    }
 
    public void setVisitLogs(List<VisitLog> visitLogs) {
        this.visitLogs = visitLogs;
    }
}
