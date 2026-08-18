package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Doctor operations and credentials validation.
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Retrieves all doctors.
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Saves a new doctor.
     */
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Retrieves doctor availability filtered by a specific date.
     * 
     * @param doctorId The doctor's ID.
     * @param date The date to filter availabilities (format: YYYY-MM-DD).
     * @return List of availability slots matching the given date.
     */
    public List<String> getDoctorAvailability(Long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null || doctor.getAvailabilities() == null) {
            return Collections.emptyList();
        }

        // Filtrage des créneaux contenant la date spécifiée
        return doctor.getAvailabilities().stream()
                .filter(slot -> slot.startsWith(date) || slot.contains(date))
                .collect(Collectors.toList());
    }

    /**
     * Validates doctor login credentials securely by checking both email and password.
     * 
     * @param email Doctor's email.
     * @param password Doctor's password.
     * @return true if credentials match, false otherwise.
     */
    public boolean validateCredentials(String email, String password) {
        if (email == null || password == null) {
            return false;
        }
        
        Doctor doctor = doctorRepository.findByEmail(email);
        
        // Vérification de l'existence ET de la correspondance exacte du mot de passe
        return doctor != null && password.equals(doctor.getPassword());
    }
}
