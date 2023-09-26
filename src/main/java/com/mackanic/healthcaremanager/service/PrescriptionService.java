package com.mackanic.healthcaremanager.service;

import com.mackanic.healthcaremanager.model.Prescription;
import com.mackanic.healthcaremanager.repository.PatientRepository;
import com.mackanic.healthcaremanager.repository.PrescriptionRepository;
import com.mackanic.healthcaremanager.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ProviderRepository providerRepository;

    public ResponseEntity<String> writeNewPrescription(Long patientId, Long providerId, Prescription prescription) {

        try {
            prescriptionRepository.save(prescription);
            prescription.setPatient(patientRepository.findById(patientId).get());
            prescription.setProvider(providerRepository.findById(providerId).get());

            return new ResponseEntity<>("Successfully wrote prescription.", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed to write new prescription.", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deletePrescription(Long prescriptionId) {
        if (prescriptionRepository.existsById(prescriptionId)) {
            prescriptionRepository.deleteById(prescriptionId);
            return new ResponseEntity<>("Prescription " + prescriptionId + " deleted.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Prescription with id " + prescriptionId + " does not exist.", HttpStatus.BAD_REQUEST);
    }
}
