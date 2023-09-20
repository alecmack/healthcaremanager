package com.mackanic.healthcaremanager.repository;

import com.mackanic.healthcaremanager.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {


    List<Provider> findProvidersByPatientsId(Long patientId);

}
