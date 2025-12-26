package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<Appointment> createAppointment(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody Appointment appointment) {

        return new ResponseEntity<>(
                appointmentService.createAppointment(visitorId, hostId, appointment),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<List<Appointment>> getAppointmentsForHost(
            @PathVariable Long hostId) {
        return ResponseEntity.ok(
                appointmentService.getAppointmentsForHost(hostId)
        );
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsForVisitor(
            @PathVariable Long visitorId) {
        return ResponseEntity.ok(
                appointmentService.getAppointmentsForVisitor(visitorId)
        );
    }
}
