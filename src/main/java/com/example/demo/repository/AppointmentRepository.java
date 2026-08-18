package com.example.demo.repository;

import com.example.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Récupérer les rendez-vous par ID de patient
    List<Appointment> findByPatientId(Long patientId);

    // Récupérer tous les rendez-vous par ID de médecin
    List<Appointment> findByDoctorId(Long doctorId);

    // Récupérer les rendez-vous d'un médecin pour une journée spécifique
    List<Appointment> findByDoctorIdAndAppointmentTimeBetween(Long doctorId, LocalDateTime start, LocalDateTime end);
}
