package com.example.demo.repository;

import com.example.demo.entity.Host;
import java.util.*;

public interface HostRepository {
    Host save(Host h);
    Optional<Host> findById(Long id);
    Optional<Host> findByEmail(String email);
    List<Host> findAll();
}
