package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Host;
import com.example.demo.service.HostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts", description = "Host/Employee management")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createHost(@RequestBody Host host) {

        Host saved = hostService.createHost(host);

        return new ResponseEntity<>(
                new ApiResponse(true, "Host created", saved),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getHost(@PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse(true, "Host found", hostService.getHost(id))
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllHosts() {

        List<Host> hosts = hostService.getAllHosts();

        return ResponseEntity.ok(
                new ApiResponse(true, "All hosts", hosts)
        );
    }
}
