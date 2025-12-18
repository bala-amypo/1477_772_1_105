package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    // Create Visitor
    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.saveVisitor(visitor);
    }

    // Get All Visitors
    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    // Get Visitor By Id
    @GetMapping("/{id}")
    public Visitor getVisitorById(@PathVariable long id) {
        return visitorService.getVisitorById(id);
    }

    // Delete Visitor
    @DeleteMapping("/{id}")
    public String deleteVisitor(@PathVariable long id) {
        visitorService.deleteVisitor(id);
        return "Visitor deleted successfully";
    }
}
