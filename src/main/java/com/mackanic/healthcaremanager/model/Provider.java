package com.mackanic.healthcaremanager.model;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String occupation;


    @ManyToMany

    private List<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

}
