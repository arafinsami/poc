package com.poc.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.poc.model.Contact;
import com.poc.model.Employee;
import com.poc.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PersonDataService {

	public static final Logger LOGGER = LoggerFactory.getLogger(PersonDataService.class);
	
	public JsonNode getEmployee() throws JsonMappingException, JsonProcessingException {
		Employee employee = Employee.builder()
				.id(1)
				.name("Sami")
				.contacts(Arrays.asList(new Contact(1, "BD"), new Contact(2, "SG")))
				.build();
		JsonNode sessionNode = JsonUtils.toNode(employee);
		LOGGER.info("json data {}", sessionNode);
		return sessionNode;
	}
}
