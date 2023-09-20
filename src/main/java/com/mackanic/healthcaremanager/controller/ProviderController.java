package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Patient;
import com.mackanic.healthcaremanager.model.Provider;
import com.mackanic.healthcaremanager.service.ProviderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @PostMapping("register")
    public ResponseEntity<String> addProvider(@RequestBody Provider provider) {
        return providerService.addProvider(provider);
    }

    @GetMapping("viewPatient/{userId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long userId) {
        return providerService.getPatient(userId);

    }

    @PostMapping("registerPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        return providerService.addPatient(patient);
    }

    @DeleteMapping("deletePatient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        return providerService.deletePatient(patientId);
    }

    @GetMapping("viewAllPatients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return providerService.getAllPatients();
    }

    @GetMapping("viewPatients/{providerId}")
    public ResponseEntity<List<Patient>> getPatientsByProviderId(@PathVariable Long providerId) {

        return providerService.getPatientsByProviderId(providerId);
    }

}
