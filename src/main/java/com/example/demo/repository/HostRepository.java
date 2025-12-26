package com.example.demo.repository;

import com.example.demo.entity.Host;
import java.util.List;
import java.util.Optional;

public interface HostRepository {

    Host save(Host host);

    Optional<Host> findById(Long id);

    List<Host> findAll();
}
