package com.mackanic.healthcaremanager.service;

import com.mackanic.healthcaremanager.model.Patient;
import com.mackanic.healthcaremanager.model.Provider;
import com.mackanic.healthcaremanager.repository.PatientRepository;
import com.mackanic.healthcaremanager.repository.ProviderRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<String> addProvider(Provider provider) {

        try {
            providerRepository.save(provider);
            return new ResponseEntity<>("Successfully added provider.", HttpStatus.CREATED);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed to register provider", HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Patient> getPatient(Long patientId) {

        try {
            Optional<Patient> patient = patientRepository.findById(patientId);
            return new ResponseEntity<>(patient.get() , HttpStatus.FOUND);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);



    }

    public ResponseEntity<String> addPatient(Patient patient) {

        try {
            patientRepository.save(patient);
            return new ResponseEntity<>("Successfully added patient.", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed to add patient.", HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> deletePatient(Long patientId) {

        boolean exists = patientRepository.existsById(patientId);

        if(!exists) {
            throw new IllegalStateException("Patient with id " + patientId + " does not exists.");
        }
        patientRepository.deleteById(patientId);


    }
}
