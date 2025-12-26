package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;


public interface HostRepository {
    Host save(Host h);
    Optional<Host> findById(Long id);
    Optional<Host> findByEmail(String email);
}
