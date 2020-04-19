package com.synechron.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.synechron.entity.HealthInsurancePlan;
import com.synechron.service.HealthInsurancePlanServices;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/plans")
public class HealthInsurancePlanController {

	@Autowired
	private HealthInsurancePlan healthInsurancePlan;
	
	@Autowired
	private HealthInsurancePlanServices healthInsurancePlanServices;
	
	@GetMapping
	public List<HealthInsurancePlan> getPlans() {
		List<HealthInsurancePlan> listHealthInsurancePlans = healthInsurancePlanServices.getPlans();
		System.out.println("in getPlans");
		System.out.println(listHealthInsurancePlans);
		return listHealthInsurancePlans;
		
	}
	
	@GetMapping("/{plan-number}")
	public HealthInsurancePlan getPlansById(@Valid @PathVariable("plan-number") Integer planNumber) {
		HealthInsurancePlan listHealthInsurancePlans = healthInsurancePlanServices.getPlansById(planNumber);
		System.out.println("in getPlans");
		System.out.println(listHealthInsurancePlans);
		return listHealthInsurancePlans;
		
	}
	
	@DeleteMapping("/{plan-number}")
	public void deletePlan(@Valid @PathVariable("plan-number") Integer planNumber) {
		System.out.println("***********in delete***************");
		healthInsurancePlanServices.deletePlan(planNumber);
	}
	
	@PostMapping
	public HealthInsurancePlan addPlan(@Valid @RequestBody HealthInsurancePlan healthInsurancePlan)
	{
		System.out.println("******exception**********");
		return healthInsurancePlanServices.addPlan(healthInsurancePlan);
	}
	
	@PutMapping("/{plan-number}")
	public HealthInsurancePlan updatePlan(@Valid @PathVariable("plan-number") Integer planNumber, @RequestBody HealthInsurancePlan healthInsurancePlan )
	{
		return healthInsurancePlanServices.updatePlan(planNumber, healthInsurancePlan);
	}
}
