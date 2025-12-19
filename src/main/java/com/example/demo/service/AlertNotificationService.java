package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import java.util.List;

public interface AlertNotificationService {

    AlertNotification saveAlert(AlertNotification alertNotification);

    List<AlertNotification> getAllAlerts();

    AlertNotification getAlertById(long id);

    void deleteAlert(long id);
}
