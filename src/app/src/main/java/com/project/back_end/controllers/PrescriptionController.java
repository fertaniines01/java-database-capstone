package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/add/{token}")
    public ResponseEntity<Map<String, String>> createPrescription(
            @PathVariable String token, 
            @RequestBody Prescription prescription) {
        
        Map<String, String> response = new HashMap<>();
        
        if (!tokenService.validateToken(token)) {
            response.put("error", "Unauthorized access - Invalid Token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        
        prescriptionService.savePrescription(prescription);
        response.put("message", "Prescription created successfully");
        return ResponseEntity.ok(response);
    }
}
