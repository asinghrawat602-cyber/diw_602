package com.example.deeputsav.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String visitorToken;

    @Column(nullable = false)
    private LocalDateTime firstVisit;

    public Visitor() {
    }

    public Visitor(String visitorToken) {
        this.visitorToken = visitorToken;
        this.firstVisit = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getVisitorToken() {
        return visitorToken;
    }

    public void setVisitorToken(String visitorToken) {
        this.visitorToken = visitorToken;
    }

    public LocalDateTime getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(LocalDateTime firstVisit) {
        this.firstVisit = firstVisit;
    }
}
