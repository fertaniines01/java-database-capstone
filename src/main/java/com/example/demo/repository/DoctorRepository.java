package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(d.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Doctor> searchDoctorsByName(@Param("keyword") String keyword);
}
