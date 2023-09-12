package com.mackanic.healthcaremanager.Provider;

import com.mackanic.healthcaremanager.Appointment.Appointment;
import com.mackanic.healthcaremanager.Patient.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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
    private String phone;
    private String address;
    private String occupation;


    @ManyToMany
    private List<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;

}
