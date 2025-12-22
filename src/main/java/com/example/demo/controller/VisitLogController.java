package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@Tag(name = "Visit Logs", description = "Visitor check-in and check-out")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkIn(
            @PathVariable Long visitorId,
            @PathVariable Long hostId,
            @RequestBody @NotBlank String purpose) {

        VisitLog visitLog = visitLogService.checkInVisitor(visitorId, hostId, purpose);
        return new ResponseEntity<>(visitLog, HttpStatus.CREATED);
    }

    @PostMapping("/checkout/{visitLogId}")
    public VisitLog checkOut(@PathVariable Long visitLogId) {
        return visitLogService.checkOutVisitor(visitLogId);
    }

    @GetMapping("/active")
    public List<VisitLog> getActiveVisits() {
        return visitLogService.getActiveVisits();
    }

    @GetMapping("/{id}")
    public VisitLog getVisitLog(@PathVariable Long id) {
        return visitLogService.getVisitLog(id);
    }
}
