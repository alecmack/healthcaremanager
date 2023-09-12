package com.mackanic.healthcaremanager.Prescription;

import com.mackanic.healthcaremanager.Patient.Patient;
import com.mackanic.healthcaremanager.Provider.Provider;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String medication;
    private Integer strength;
    private Integer amount;
    private Integer frequency;
    private Integer refills;
    private Date datePrescribed;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Provider provider;




}
