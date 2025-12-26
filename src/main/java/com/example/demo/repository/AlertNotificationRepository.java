package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;


public interface AlertNotificationRepository {
    AlertNotification save(AlertNotification a);
    Optional<AlertNotification> findById(Long id);
    Optional<AlertNotification> findByVisitLogId(Long visitLogId);
    List<AlertNotification> findAll();
}
