package com.example.demo.service;

import com.example.demo.model.Host;
import com.example.demo.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostRepository hostRepository;

    @Override
    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    @Override
    public Host getHostById(long id) {
        return hostRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHost(long id) {
        hostRepository.deleteById(id);
    }
}
