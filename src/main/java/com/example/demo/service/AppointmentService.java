package com.example.demo.service;

import com.example.demo.entity.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment scheduleAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    List<Appointment> getAllAppointments();
}
