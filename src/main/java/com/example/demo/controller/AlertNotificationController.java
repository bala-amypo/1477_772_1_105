package com.example.demo.controller;

import com.example.demo.entity.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send/{visitLogId}")
    public ResponseEntity<AlertNotification> sendAlert(
            @PathVariable Long visitLogId) {

        return new ResponseEntity<>(
                alertService.sendAlert(visitLogId),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertNotification> getAlert(
            @PathVariable Long id) {

        return ResponseEntity.ok(alertService.getAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<AlertNotification>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
}
