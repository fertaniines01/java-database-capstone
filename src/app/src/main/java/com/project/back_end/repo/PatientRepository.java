package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Patient entity persistence operations.
 * Extends JpaRepository to provide standard CRUD operations.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Finds a Patient entity by their unique email address.
     * 
     * @param email The email address of the patient to search for.
     * @return An Optional containing the Patient if found, or empty if not.
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Finds a Patient entity by matching either their email address or phone number.
     * Useful for login validation or avoiding duplicate patient registrations.
     * 
     * @param email The email address to check.
     * @param phone The phone number to check.
     * @return An Optional containing the matching Patient if found, or empty if not.
     */
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
