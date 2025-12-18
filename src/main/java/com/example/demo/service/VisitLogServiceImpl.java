package com.example.demo.service;

import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Autowired
    private VisitLogRepository visitLogRepository;

    @Override
    public VisitLog saveVisitLog(VisitLog visitLog) {
        return visitLogRepository.save(visitLog);
    }

    @Override
    public List<VisitLog> getAllVisitLogs() {
        return visitLogRepository.findAll();
    }

    @Override
    public VisitLog getVisitLogById(long id) {
        return visitLogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVisitLog(long id) {
        visitLogRepository.deleteById(id);
    }
}
