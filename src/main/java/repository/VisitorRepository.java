package com.example.deeputsav.repository;

import com.example.deeputsav.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository
        extends JpaRepository<Visitor, Long> {

    Optional<Visitor> findByVisitorToken(String visitorToken);

    long count();
}
