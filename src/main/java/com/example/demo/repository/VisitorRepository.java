package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface VisitorRepository {
    Visitor save(Visitor v);
    Optional<Visitor> findById(Long id);
    List<Visitor> findAll();
}
