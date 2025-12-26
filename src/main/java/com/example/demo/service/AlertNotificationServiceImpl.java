package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import java.time.LocalDateTime;
import java.util.List;

public class AlertNotificationServiceImpl {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl() {}

    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog vl = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }

        AlertNotification a = new AlertNotification();
        a.setVisitLog(vl);
        a.setSentTo(vl.getHost().getEmail());
        a.setSentAt(LocalDateTime.now());

        vl.setAlertSent(true);
        visitLogRepository.save(vl);

        return alertRepository.save(a);
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
