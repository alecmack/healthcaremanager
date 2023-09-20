package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("register")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping("list")
    public ResponseEntity<List<Appointment>> showAllAppointments() {
        return appointmentService.showAllAppointments();
    }

    @GetMapping("show/{appointmentId}")
    public ResponseEntity<Appointment> showAppointment(@PathVariable Long appointmentId) {
        return appointmentService.showAppointment(appointmentId);
    }

    @GetMapping("list/{patientId}")
    public ResponseEntity<List<Appointment>> showPatientAppointments(@PathVariable Long patientId) {
        return appointmentService.showPatientAppointments(patientId);
    }


    @DeleteMapping("delete/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }


}
