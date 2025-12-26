package com.example.demo.service;

import com.example.demo.entity.Host;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HostRepository;
import java.util.List;

public class HostServiceImpl {

    private HostRepository hostRepository;

    public HostServiceImpl() {}

    public Host createHost(Host h) {
        return hostRepository.save(h);
    }

    public Host getHost(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));
    }

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
