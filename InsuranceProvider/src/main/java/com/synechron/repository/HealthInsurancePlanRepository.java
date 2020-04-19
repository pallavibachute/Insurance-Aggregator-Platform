package com.synechron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.entity.HealthInsurancePlan;

public interface HealthInsurancePlanRepository extends JpaRepository<HealthInsurancePlan, Integer> {

	
}
