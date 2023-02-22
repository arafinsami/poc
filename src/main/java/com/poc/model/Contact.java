package com.poc.model;

import lombok.Getter;

@Getter
public class Contact {

	private int id;

	private String location;

	public Contact(int id, String location) {
		this.id = id;
		this.location = location;
	}

}
