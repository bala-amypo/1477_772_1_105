package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceImpl {

    private AppointmentRepository appointmentRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public AppointmentServiceImpl(AppointmentRepository ar, VisitorRepository vr, HostRepository hr) {
        this.appointmentRepository = ar;
        this.visitorRepository = vr;
        this.hostRepository = hr;
    }

    public Appointment createAppointment(Long visitorId, Long hostId, Appointment ap) {
        if (ap.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("appointmentDate cannot be past");
        }

        ap.setVisitor(visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found")));

        ap.setHost(hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found")));

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
