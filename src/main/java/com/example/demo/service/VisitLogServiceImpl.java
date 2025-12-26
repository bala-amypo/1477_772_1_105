package com.example.demo.service;

import com.example.demo.entity.VisitLog;
import com.example.demo.repository.VisitLogRepository;

import java.util.List;

public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository visitLogRepository;

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository) {
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public VisitLog addVisitLog(VisitLog visitLog) {
        return visitLogRepository.save(visitLog);
    }

    @Override
    public VisitLog getVisitLogById(Long id) {
        return visitLogRepository.findById(id).orElse(null);
    }

    @Override
    public List<VisitLog> getAllVisitLogs() {
        return visitLogRepository.findAll();
    }
}
