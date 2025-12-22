package com.example.demo.controller;

import com.example.demo.entity.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    // Send alert for a visit log
    @PostMapping("/send/{visitLogId}")
    public AlertNotification sendAlert(@PathVariable Long visitLogId) {
        return alertService.sendAlert(visitLogId);
    }

    // Get alert by ID
    @GetMapping("/{id}")
    public AlertNotification getAlert(@PathVariable Long id) {
        return alertService.getAlert(id);
    }

    // Get all alerts
    @GetMapping
    public List<AlertNotification> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
