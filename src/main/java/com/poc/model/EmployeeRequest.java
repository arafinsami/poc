package com.poc.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeRequest {

	private String email;
	
	private Employee employee;
}
