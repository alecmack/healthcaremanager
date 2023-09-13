package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Patient;
import com.mackanic.healthcaremanager.model.Provider;
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

    @PostMapping("signIn")
    public ResponseEntity<String> signIn(@RequestBody String email, @RequestBody String password) {
        return providerService.signIn(email, password);
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

    @PostMapping("appointment/register")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
        return providerService.bookAppointment(appointment);
    }

    @GetMapping("appointment/list")
    public ResponseEntity<List<Appointment>> showAllAppointments() {
        return providerService.showAllAppointments();
    }

    @GetMapping("appointment/show/{appointmentId")
    public ResponseEntity<Appointment> showAppointment(@PathVariable Long appointmentId) {
        return providerService.showAppointment(appointmentId);
    }

    @GetMapping("appointment/list/{patientId}")
    public ResponseEntity<List<Appointment>> showPatientAppointments(@PathVariable Long patientId) {
        return providerService.showPatientAppointments(patientId);
    }


    @DeleteMapping("appointment/delete/{appointmentId")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
        return providerService.deleteAppointment(appointmentId);
    }







}
