package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Host;

public interface HostService {

    Host saveHost(Host host);

    Host getHostById(Long id);

    List<Host> getAllHosts();
}
