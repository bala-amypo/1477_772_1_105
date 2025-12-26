package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl {

    public AppointmentRepository appointmentRepository;
    public VisitorRepository visitorRepository;
    public HostRepository hostRepository;

    public AppointmentServiceImpl(AppointmentRepository a, VisitorRepository v, HostRepository h) {
        this.appointmentRepository = a;
        this.visitorRepository = v;
        this.hostRepository = h;
    }

    public Appointment createAppointment(Long visitorId, Long hostId, Appointment ap) {

        if (ap.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("appointmentDate cannot be past");
        }

        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        ap.setVisitor(v);
        ap.setHost(h);
        ap.setStatus("SCHEDULED");

        return appointmentRepository.save(ap);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
    }

    public List<Appointment> getAppointmentsForHost(Long hostId) {
        return appointmentRepository.findByHostId(hostId);
    }

    public List<Appointment> getAppointmentsForVisitor(Long visitorId) {
        return appointmentRepository.findByVisitorId(visitorId);
    }
}
