package com.example.demo.service;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;

public interface AlertNotificationService {

    AlertNotification createAlert(VisitLog visitLog);
}
