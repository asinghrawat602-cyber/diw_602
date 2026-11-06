package com.example.deeputsav.service;

import com.example.deeputsav.model.Visitor;
import com.example.deeputsav.repository.VisitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Transactional
    public long registerVisitor(String visitorToken) {

        if (visitorToken == null || visitorToken.isBlank()) {
            throw new IllegalArgumentException(
                    "Visitor token cannot be empty"
            );
        }

        String token = visitorToken.trim();

        if (token.length() > 100) {
            throw new IllegalArgumentException(
                    "Invalid visitor token"
            );
        }

        visitorRepository.findByVisitorToken(token)
                .orElseGet(() ->
                        visitorRepository.save(new Visitor(token))
                );

        return visitorRepository.count();
    }

    @Transactional(readOnly = true)
    public long getTotalVisitors() {
        return visitorRepository.count();
    }
}
