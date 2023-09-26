package com.mackanic.healthcaremanager.model;

import com.mackanic.healthcaremanager.model.Appointment;
import com.mackanic.healthcaremanager.model.Patient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinTable(name = "provider_patients",
            joinColumns = { @JoinColumn(name = "provider_id") },
            inverseJoinColumns = { @JoinColumn(name = "patient_id") })
    private Set<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

//    public Provider(long id, String firstName, String lastName, String email, String password, String phone, String address, String occupation) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.phone = phone;
//        this.address = address;
//        this.occupation = occupation;
//        this.patients = new HashSet<>();
//        this.appointments = new ArrayList<>();
//    }
}
