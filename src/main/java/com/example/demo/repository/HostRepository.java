package com.example.demo.repository;

import com.example.demo.entity.Host;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

    Optional<Host> findByEmail(String email);
}
