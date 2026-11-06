package com.example.deeputsav.controller;

import com.example.deeputsav.service.VisitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins = "*")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVisitor(
            @RequestBody Map<String, String> request) {

        try {
            String token = request.get("visitorToken");

            long total = visitorService.registerVisitor(token);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "totalVisitors", total,
                    "message", "Visitor registered successfully"
            ));

        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", exception.getMessage()
            ));
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getVisitorCount() {

        return ResponseEntity.ok(Map.of(
                "success", true,
                "totalVisitors", visitorService.getTotalVisitors()
        ));
    }
}
