package com.mackanic.healthcaremanager.service;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.repository.AppointmentRepository;
import com.mackanic.healthcaremanager.repository.PatientRepository;
import com.mackanic.healthcaremanager.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ProviderRepository providerRepository;

    public ResponseEntity<String> bookAppointment(Long patientId, Long providerId, Appointment appointment) {

        try {
            appointmentRepository.save(appointment);
            appointment.setPatient(patientRepository.getReferenceById(patientId));
            appointment.setProvider(providerRepository.getReferenceById(providerId));
            return new ResponseEntity<>("Successfully booked appointment.", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to book appointment.", HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Appointment>> showAllAppointments() {

        try {
            return new ResponseEntity<>(appointmentRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(appointmentRepository.findAll(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Appointment> showAppointment(Long appointmentId) {

        try {
            Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
            return new ResponseEntity<>(appointment.get() , HttpStatus.FOUND);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Appointment>> showPatientAppointments(Long patientId) {

        try {
            return new ResponseEntity<>(appointmentRepository.findByPatientId(patientId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(appointmentRepository.findByPatientId(patientId), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteAppointment(Long appointmentId) {


        boolean exists = appointmentRepository.existsById(appointmentId);

        if(!exists) {
            throw new IllegalStateException("Appointment with id " + appointmentId + " does not exists.");
        }
        appointmentRepository.deleteById(appointmentId);

        return new ResponseEntity<>("Appointment " + appointmentId + " successfully deleted.", HttpStatus.OK);
    }

}
