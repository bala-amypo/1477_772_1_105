package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {

    @Autowired
    private AlertNotificationService alertNotificationService;

    // Create Alert
    @PostMapping
    public AlertNotification createAlert(
            @RequestBody AlertNotification alertNotification) {
        return alertNotificationService.saveAlert(alertNotification);
    }

    // Get All Alerts
    @GetMapping
    public List<AlertNotification> getAllAlerts() {
        return alertNotificationService.getAllAlerts();
    }

    // Get Alert By Id
    @GetMapping("/{id}")
    public AlertNotification getAlertById(@PathVariable long id) {
        return alertNotificationService.getAlertById(id);
    }

    // Delete Alert
    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable long id) {
        alertNotificationService.deleteAlert(id);
        return "Alert deleted successfully";
    }
}
