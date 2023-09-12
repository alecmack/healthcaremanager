package com.mackanic.healthcaremanager.Appointment;

import com.mackanic.healthcaremanager.Patient.Patient;
import com.mackanic.healthcaremanager.Provider.Provider;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String symptoms;
    private Double temperature;
    private Double bloodPressure;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Patient patient;



}
