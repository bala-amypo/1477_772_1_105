package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkIn(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody String purpose) {

        return new ResponseEntity<>(
                visitLogService.checkInVisitor(visitorId, hostId, purpose),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/checkout/{visitLogId}")
    public ResponseEntity<VisitLog> checkOut(
            @PathVariable Long visitLogId) {

        return ResponseEntity.ok(
                visitLogService.checkOutVisitor(visitLogId)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> getActiveVisits() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getVisitLog(id));
    }
}
