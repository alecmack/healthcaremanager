package com.mackanic.healthcaremanager.repository;

import com.mackanic.healthcaremanager.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {


}
