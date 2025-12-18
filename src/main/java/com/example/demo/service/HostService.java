package com.example.demo.service;

import com.example.demo.model.Host;
import java.util.List;

public interface HostService {

    Host saveHost(Host host);

    List<Host> getAllHosts();

    Host getHostById(long id);

    void deleteHost(long id);
}
