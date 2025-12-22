package com.example.demo.controller;

import com.example.demo.entity.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Alert notifications to hosts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send/{visitLogId}")
    public ResponseEntity<AlertNotification> sendAlert(@PathVariable Long visitLogId) {
        AlertNotification alert = alertService.sendAlert(visitLogId);
        return new ResponseEntity<>(alert, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AlertNotification getAlert(@PathVariable Long id) {
        return alertService.getAlert(id);
    }

    @GetMapping
    public List<AlertNotification> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
