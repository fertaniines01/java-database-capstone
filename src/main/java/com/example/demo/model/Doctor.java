package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Specialty is required")
    @Column(nullable = false)
    private String specialty;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @ElementCollection
    @CollectionTable(name = "doctor_availabilities", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "availability_slot")
    private List<String> availabilities = new ArrayList<>();

    // Constructeurs
    public Doctor() {}

    public Doctor(String name, String specialty, String email, List<String> availabilities) {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.availabilities = availabilities;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getAvailabilities() { return availabilities; }
    public void setAvailabilities(List<String> availabilities) { this.availabilities = availabilities; }

    // Méthodes utilitaires pour enrichir la classe
    public void addAvailability(String slot) {
        if (this.availabilities == null) {
            this.availabilities = new ArrayList<>();
        }
        this.availabilities.add(slot);
    }

    public void removeAvailability(String slot) {
        if (this.availabilities != null) {
            this.availabilities.remove(slot);
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", email='" + email + '\'' +
                ", availabilities=" + availabilities +
                '}';
    }
}
