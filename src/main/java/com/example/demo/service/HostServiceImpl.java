package com.example.demo.service;

import com.example.demo.entity.Host;
import com.example.demo.repository.HostRepository;

import java.util.List;

public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Host addHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host getHostById(Long id) {
        return hostRepository.findById(id).orElse(null);
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
