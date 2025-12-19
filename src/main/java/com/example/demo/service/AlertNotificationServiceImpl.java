package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    @Autowired
    private AlertNotificationRepository alertNotificationRepository;

    @Override
    public AlertNotification saveAlert(AlertNotification alertNotification) {
        return alertNotificationRepository.save(alertNotification);
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }

    @Override
    public AlertNotification getAlertById(long id) {
        return alertNotificationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlert(long id) {
        alertNotificationRepository.deleteById(id);
    }
}
