package com.mackanic.healthcaremanager.repository;

import com.mackanic.healthcaremanager.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {


    List<Prescription> findByPatientId(Long patientId);
}
