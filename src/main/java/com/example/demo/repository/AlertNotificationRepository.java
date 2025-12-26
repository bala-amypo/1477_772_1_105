package com.example.demo.repository;

import com.example.demo.entity.AlertNotification;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> {

    Optional<AlertNotification> findByVisitLogId(Long visitLogId);
}
