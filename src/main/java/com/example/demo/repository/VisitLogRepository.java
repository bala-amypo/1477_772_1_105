package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;
public interface VisitLogRepository {
    VisitLog save(VisitLog v);
    Optional<VisitLog> findById(Long id);
    List<VisitLog> findByCheckOutTimeIsNull();
}
