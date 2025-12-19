package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostController {

    @Autowired
    private HostService hostService;

    // Create Host
    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }

    // Get All Hosts
    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    // Get Host By Id
    @GetMapping("/{id}")
    public Host getHostById(@PathVariable long id) {
        return hostService.getHostById(id);
    }

    // Delete Host
    @DeleteMapping("/{id}")
    public String deleteHost(@PathVariable long id) {
        hostService.deleteHost(id);
        return "Host deleted successfully";
    }
}
