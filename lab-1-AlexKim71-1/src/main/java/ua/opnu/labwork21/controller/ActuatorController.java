package ua.opnu.labwork21.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

    @GetMapping("/actuator/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("GET /actuator/health OK");
    }

    @GetMapping("/actuator/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("GET /actuator/info OK");
    }

    @GetMapping("/actuator/metrics")
    public ResponseEntity<String> metrics() {
        return ResponseEntity.ok("GET /actuator/metrics OK");
    }
}

