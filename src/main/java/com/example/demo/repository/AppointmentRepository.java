package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import java.util.*;

public interface AppointmentRepository {
    Appointment save(Appointment a);
    Optional<Appointment> findById(Long id);
    List<Appointment> findByHostId(Long hostId);
    List<Appointment> findByVisitorId(Long visitorId);
    List<Appointment> findAll();
}
