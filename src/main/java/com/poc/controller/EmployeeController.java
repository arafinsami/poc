package com.poc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.poc.model.EmployeeMapper;
import com.poc.model.EmployeeRequest;
import com.poc.service.PersonDataService;
import com.poc.utils.JsonUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

	private final PersonDataService personDataService;

	@PostMapping
	ResponseEntity<Object> getEmployee(@RequestBody EmployeeRequest request)
			throws JsonMappingException, JsonProcessingException {

		JsonNode sessionNode = personDataService.getEmployee();
		JsonNode requestNode = JsonUtils.toNode(request);

		if (!requestNode.equals(sessionNode)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		EmployeeMapper employeeMapper = EmployeeMapper.builder()
				.request(request)
				.build();

		return new ResponseEntity<>(employeeMapper, HttpStatus.CREATED);
	}
}
