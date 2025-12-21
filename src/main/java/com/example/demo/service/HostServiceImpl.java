package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import com.example.demo.service.HostService;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host getHostById(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Host not found"));
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
