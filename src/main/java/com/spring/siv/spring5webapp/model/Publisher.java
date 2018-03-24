package com.spring.siv.spring5webapp.model;

import javax.persistence.Entity;

@Entity
public class Publisher {
	private String name;
	private String address;
	
	public Publisher(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
