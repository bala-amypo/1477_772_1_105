package com.example.demo.service;

import com.example.demo.entity.Host;
import java.util.List;

public interface HostService {

    Host addHost(Host host);

    Host getHostById(Long id);

    List<Host> getAllHosts();
}
