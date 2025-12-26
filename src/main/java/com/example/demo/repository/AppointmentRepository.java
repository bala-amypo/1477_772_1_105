package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByHostId(Long hostId);

    List<Appointment> findByVisitorId(Long visitorId);
}
