package com.example.demo.service;

import com.example.demo.model.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(long id);

    void deleteAppointment(long id);
}
