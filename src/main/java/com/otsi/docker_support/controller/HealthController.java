package com.otsi.docker_support.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> body = Map.of(
                "status", "UP",
                "timestamp", Instant.now().toString()
        );

        return ResponseEntity.ok()
                .cacheControl(CacheControl.noStore())
                .body(body);
    }

    @GetMapping("/ready")
    public ResponseEntity<Map<String, Object>> readiness() {
        Map<String, Object> body = Map.of(
                "status", "READY",
                "timestamp", Instant.now().toString()
        );

        return ResponseEntity.ok()
                .cacheControl(CacheControl.noStore())
                .body(body);
    }
}