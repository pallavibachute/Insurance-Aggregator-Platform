package com.synechron.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.synechron.entity.HealthInsurancePlan;
import com.synechron.exceptions.DataNotFoundException;
import com.synechron.repository.HealthInsurancePlanRepository;



@Service
public class HealthInsurancePlanServices {

	@Autowired
	private HealthInsurancePlanRepository healthInsurancePlanRepository;
	
	@Autowired
	private HealthInsurancePlan healthInsurancePlan;

	
	public List<HealthInsurancePlan> getPlans() {
		System.out.println();
		if(healthInsurancePlanRepository.count()!=0)
			return healthInsurancePlanRepository.findAll();
		else throw new DataNotFoundException("Plans Not available");
			
	}
	
	
	public HealthInsurancePlan getPlansById(Integer planNumber) {
		System.out.println();
		/*
		 * if(healthInsurancePlanRepository.count()!=0) return
		 * healthInsurancePlanRepository.findById(planNumber); else throw new
		 * DataNotFoundException("Plans Not available");
		 */
		  Optional<HealthInsurancePlan> plan = healthInsurancePlanRepository.findById(planNumber);
		if(plan.isPresent())
			return plan.get();
		else throw new DataNotFoundException("Plan Not available");
			
	}
	
	
	public void deletePlan(Integer planNumber) {

		if (healthInsurancePlanRepository.findById(planNumber).isPresent())
			healthInsurancePlanRepository.deleteById(planNumber);
		else
			throw new DataNotFoundException("Plan Not Found:" + planNumber);

	}
	
	
	public HealthInsurancePlan addPlan(HealthInsurancePlan healthInsurancePlan) {
		return healthInsurancePlanRepository.saveAndFlush(healthInsurancePlan);
	}
	
	/*
	 * public Optional<HealthInsurancePlan> getPlanById(Integer planNumber ) {
	 * 
	 * return healthInsurancePlanRepository.findById(planNumber);
	 * 
	 * }
	 */
	
	public HealthInsurancePlan updatePlan(Integer planNumber, HealthInsurancePlan healthInsurancePlan) {
		Optional<HealthInsurancePlan> updatequery = healthInsurancePlanRepository.findById(planNumber);
		System.out.println("healthInsurancePlan");
		System.out.println(healthInsurancePlan);
		if(updatequery.isPresent())
		{	
			HealthInsurancePlan healthInsurancePlandb=updatequery.get();
			return healthInsurancePlanRepository.saveAndFlush(healthInsurancePlan);
		}
		else throw new DataNotFoundException("Plan not present:" +planNumber);
			/*
		if(healthInsurancePlanRepository.findById(policyNumber).isPresent())
			return healthInsurancePlanRepository.saveAndFlush(healthInsurancePlan);*/
	
		
	}
}
