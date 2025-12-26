package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.time.LocalDateTime;
import java.util.List;

public class AlertNotificationServiceImpl {

    public AlertNotificationRepository alertRepository;
    public VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    public AlertNotification sendAlert(Long visitLogId) {

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());

        log.setAlertSent(true);
        visitLogRepository.save(log);

        return alertRepository.save(alert);
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
