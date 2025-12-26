package com.example.demo.service;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;

import java.time.LocalDateTime;

public class AlertNotificationServiceImpl {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {
    }

    public AlertNotification sendAlert(Long visitLogId) {

        VisitLog vl = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(vl);
        alert.setSentTo(vl.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());

        vl.setAlertSent(true);
        visitLogRepository.save(vl);

        return alertRepository.save(alert);
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public java.util.List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
