package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Prescription;
import com.mackanic.healthcaremanager.model.Provider;
import com.mackanic.healthcaremanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("appointments/{patientId}")
    public ResponseEntity<List<Appointment>> getAllAppointments(@PathVariable Long patientId) {

        return patientService.getAllAppointments(patientId);
    }

    @GetMapping("prescriptions/{patientId}")
    public ResponseEntity<List<Prescription>> getAllPrescriptions(@PathVariable Long patientId) {

        return patientService.getAllPrescriptions(patientId);
    }

    @GetMapping("providers/{patientId}")
    public ResponseEntity<List<Provider>> getProvidersByPatientId(@PathVariable Long patientId) {

        return patientService.getProvidersByPatientId(patientId);
    }








}
