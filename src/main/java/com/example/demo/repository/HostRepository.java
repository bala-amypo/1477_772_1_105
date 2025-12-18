package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Host;

public interface HostRepository extends JpaRepository<Host, Long> {
}
