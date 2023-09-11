package com.mackanic.healthcaremanager.Patient;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.mackanic.healthcaremanager.Provider.Provider;


@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private Double weight;
    private Double height;
    private String email;
    private String phone;
    private String bloodType;
    private String address;
    private String insuranceCompany;
    private String insuranceNumber;


    @ManyToMany
    private List<Provider> providers;

    @OneToMany
    private List<Prescription> prescriptions;

    @OneToMany
    private List<Appointment> appointments;





}
