package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Patient;
import com.mackanic.healthcaremanager.model.Provider;
import com.mackanic.healthcaremanager.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("viewAllProviders")
    public ResponseEntity<List<Provider>> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PostMapping("register")
    public ResponseEntity<String> addProvider(@RequestBody Provider provider) {
        return providerService.addProvider(provider);
    }

    @DeleteMapping("deleteProvider/{providerId}")
    public ResponseEntity<String> deleteProvider(@PathVariable Long providerId) {
        return providerService.deleteProvider(providerId);
    }

    @GetMapping("viewPatient/{userId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long userId) {
        return providerService.getPatient(userId);

    }

    @PostMapping("registerPatient/{providerId}")
    public ResponseEntity<String> addPatient(@PathVariable Long providerId, @RequestBody Patient patient) {
        return providerService.addPatient(providerId, patient);
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

    @PutMapping("addProviderToPatient/{providerId}/{patientId}")
    public ResponseEntity<String> addProviderToPatient(@PathVariable Long providerId, @PathVariable Long patientId) {

        return providerService.addProviderToPatient(providerId, patientId);

    }

}
