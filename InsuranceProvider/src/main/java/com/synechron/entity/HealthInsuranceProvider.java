package com.synechron.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HealthInsuranceProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long healthInsuranceProviderId;
	private String healthInsuranceProviderName;

}
