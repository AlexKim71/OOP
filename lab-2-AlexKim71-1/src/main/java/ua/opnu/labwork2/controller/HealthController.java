package ua.opnu.labwork2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * HealthController - REST API controller for health checks
 * Контролер здоров'я сервісу - REST API контролер для перевірки здоров'я
 */
@RestController
@RequestMapping("/actuator")
public class HealthController {

    /**
     * Check service health
     * Перевірити здоров'я сервісу
     * GET /actuator/health
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealth() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Hotel Management Service is running");
        return ResponseEntity.ok(response);
    }

    /**
     * Get metrics
     * Отримати метрики
     * GET /actuator/metrics
     */
    @GetMapping("/metrics")
    public ResponseEntity<Map<String, String>> getMetrics() {
        Map<String, String> response = new HashMap<>();
        response.put("availableMetrics", "Use /actuator/metrics/{metric.name}");
        return ResponseEntity.ok(response);
    }

    /**
     * Get Prometheus metrics
     * Отримати Prometheus метрики
     * GET /actuator/prometheus
     */
    @GetMapping("/prometheus")
    public ResponseEntity<String> getPrometheus() {
        return ResponseEntity.ok("Prometheus metrics endpoint");
    }
}

