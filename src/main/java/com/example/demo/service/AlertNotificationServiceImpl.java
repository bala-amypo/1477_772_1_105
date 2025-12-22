package com.example.demo.service;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    @Override
    public AlertNotification createAlert(VisitLog visitLog) {

        AlertNotification alert = new AlertNotification();

        alert.setVisitLog(visitLog);
        alert.setMessage("Visitor checked in successfully");
        alert.setSent(true);
        alert.setCreatedAt(LocalDateTime.now());

        return alert;
    }
}
