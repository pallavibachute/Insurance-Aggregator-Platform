package com.synechron.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HealthInsurancePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planNumber;
	
	@NotNull(message = "Plan name must not be empty")
	private String planName;
	
	@NotNull(message = "Number of Members must not be empty")
	@Min(1)
	private int numberOfMembers;
	
	@NotNull(message = "City must not be empty")
	private String city;
	
	@NotNull(message = "Cover For Years must not be empty")
	@Min(1)
	private Integer coverForYears;
	
	@NotNull(message = "sum insured must not be empty")
	private Integer sumInsured;
	
	@NotNull(message = "premium must not be empty")
	private Integer premium;
	
}
