package com.mackanic.healthcaremanager.repository;

import com.mackanic.healthcaremanager.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatient(Long patientId);
}
