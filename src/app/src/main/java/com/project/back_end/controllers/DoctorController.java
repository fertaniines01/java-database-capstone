package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.saveDoctor(doctor));
    }

    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        Map<String, Object> response = new HashMap<>();

        // Validation du token
        if (!tokenService.validateToken(token)) {
            response.put("status", "error");
            response.put("message", "Invalid or expired token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Récupération des disponibilités
        List<String> availabilities = doctorService.getDoctorAvailability(doctorId, date);

        // Encapsulation structurée dans un Map
        response.put("status", "success");
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availabilities", availabilities);

        return ResponseEntity.ok(response);
    }
}
