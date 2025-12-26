package com.example.demo.service;

import com.example.demo.entity.AlertNotification;
import java.util.List;

public interface AlertNotificationService {

    AlertNotification sendNotification(AlertNotification notification);

    AlertNotification getNotificationById(Long id);

    List<AlertNotification> getAllNotifications();
}
