package com.example.demo.service;

import com.example.demo.entity.VisitLog;
import java.util.List;

public interface VisitLogService {

    VisitLog addVisitLog(VisitLog visitLog);

    VisitLog getVisitLogById(Long id);

    List<VisitLog> getAllVisitLogs();
}
