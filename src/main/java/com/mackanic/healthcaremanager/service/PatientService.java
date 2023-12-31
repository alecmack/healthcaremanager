package com.mackanic.healthcaremanager.service;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Prescription;
import com.mackanic.healthcaremanager.model.Provider;
import com.mackanic.healthcaremanager.repository.AppointmentRepository;
import com.mackanic.healthcaremanager.repository.PatientRepository;
import com.mackanic.healthcaremanager.repository.PrescriptionRepository;
import com.mackanic.healthcaremanager.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Autowired
    ProviderRepository providerRepository;


    public ResponseEntity<List<Appointment>> getAllAppointments(Long patientId) {

        try {
            return new ResponseEntity<>(appointmentRepository.findByPatientId(patientId), HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(appointmentRepository.findByPatientId(patientId), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Prescription>> getAllPrescriptions(Long patientId) {

        try {
            return new ResponseEntity<>(prescriptionRepository.findByPatientId(patientId), HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(prescriptionRepository.findByPatientId(patientId), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Provider>> getProvidersByPatientId(Long patientId) {

        try {
            return new ResponseEntity<>(providerRepository.findProvidersByPatientsId(patientId), HttpStatus.OK);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(providerRepository.findProvidersByPatientsId(patientId), HttpStatus.BAD_REQUEST);

    }
}
