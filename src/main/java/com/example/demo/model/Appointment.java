package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date du rendez-vous est obligatoire")
    @Future(message = "La date du rendez-vous doit être dans le futur")
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private String status;

    public Appointment() {}

    public String getFormattedDisplay() {
        return "Rendez-vous le " + appointmentTime.toString() + " avec Dr. " + (doctor != null ? doctor.getName() : "");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
