package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;
public interface AppointmentRepository {


    Optional<Appointment> findById(Long id);
    List<Appointment> findAll();
    List<Appointment> findByHostId(Long hostId);
    List<Appointment> findByVisitorId(Long visitorId);
}
