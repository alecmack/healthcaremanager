package com.mackanic.healthcaremanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;


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
    private String password;
    private String phone;
    private String bloodType;
    private String address;
    private String insuranceCompany;
    private String insuranceNumber;


    @JsonIgnore
    @ManyToMany(mappedBy = "patients")
    private Set<Provider> providers;

    @OneToMany
    private List<Prescription> prescriptions;

    @OneToMany
    private List<Appointment> appointments;

    public void addProvider(Provider provider) {
        providers.add(provider);
    }





}
