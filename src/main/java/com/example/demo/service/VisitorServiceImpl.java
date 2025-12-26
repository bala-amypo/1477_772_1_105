package com.example.demo.service;

import com.example.demo.entity.Visitor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VisitorRepository;
import java.util.List;

public class VisitorServiceImpl {

    private VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor v) {
        return visitorRepository.save(v);
    }

    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
