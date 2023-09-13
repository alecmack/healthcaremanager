package com.mackanic.healthcaremanager.service;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Prescription;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    public ResponseEntity<List<Appointment>> addPatient(Long patientId) {
        
        
    }

    public ResponseEntity<List<Prescription>> getAllPrescriptions(Long patientId) {
    }
}
