package com.example.demo.service;

import com.example.demo.entity.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;

import java.util.List;

public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository notificationRepository;

    public AlertNotificationServiceImpl(AlertNotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public AlertNotification sendNotification(AlertNotification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public AlertNotification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public List<AlertNotification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
