package com.poc.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {

	private int id;
	
	private String name;
	
	private List<Contact> contacts;
}
