package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitlogs")
public class VisitLogController {

    @Autowired
    private VisitLogService visitLogService;

    // Create Visit Log (Check-in)
    @PostMapping
    public VisitLog createVisitLog(@RequestBody VisitLog visitLog) {
        return visitLogService.saveVisitLog(visitLog);
    }

    // Get All Visit Logs
    @GetMapping
    public List<VisitLog> getAllVisitLogs() {
        return visitLogService.getAllVisitLogs();
    }

    // Get Visit Log By Id
    @GetMapping("/{id}")
    public VisitLog getVisitLogById(@PathVariable long id) {
        return visitLogService.getVisitLogById(id);
    }

    // Delete Visit Log
    @DeleteMapping("/{id}")
    public String deleteVisitLog(@PathVariable long id) {
        visitLogService.deleteVisitLog(id);
        return "VisitLog deleted successfully";
    }
}
