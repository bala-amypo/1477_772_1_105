package com.example.demo.service;

import com.example.demo.model.VisitLog;
import java.util.List;

public interface VisitLogService {

    VisitLog saveVisitLog(VisitLog visitLog);

    List<VisitLog> getAllVisitLogs();

    VisitLog getVisitLogById(long id);

    void deleteVisitLog(long id);
}
