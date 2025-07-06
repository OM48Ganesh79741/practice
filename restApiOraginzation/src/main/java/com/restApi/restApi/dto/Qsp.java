package com.restApi.restApi.dto;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Qsp 
{
	@Id
	@GeneratedValue(generator = "emp")
	@GenericGenerator(name = "emp", strategy = "com.restApi.restApi.customgeberation.CustomGrnrration")
	private String id;
	private String name;
	private String address;
	private String salary;
	
	public Qsp() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
	
	
	
	

}
