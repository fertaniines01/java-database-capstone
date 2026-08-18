package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<String> getDoctorAvailability(Long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        return doctor != null ? doctor.getAvailabilities() : Collections.emptyList();
    }

    public boolean validateCredentials(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        return doctor != null;
    }
}
