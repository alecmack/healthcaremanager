package com.mackanic.healthcaremanager.repository;

import com.mackanic.healthcaremanager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    List<Patient> findPatientsByProvidersId(Long providerId);
}
