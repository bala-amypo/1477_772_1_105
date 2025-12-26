package com.example.demo.repository;

import com.example.demo.entity.AlertNotification;
import java.util.List;
import java.util.Optional;

public interface AlertNotificationRepository {

    AlertNotification save(AlertNotification notification);

    Optional<AlertNotification> findById(Long id);

    List<AlertNotification> findAll();
}
