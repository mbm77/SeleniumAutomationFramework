package com.mbm.dataprovider;

import org.testng.annotations.DataProvider;

public class Employee {

	private String name;
	private String id;
	
	public Employee(String name,String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	@DataProvider
	public static Employee[] dataProviding() {
		Employee[] emp =  new Employee[] {
				new Employee("mbm","mbm123"),
				new Employee("john","johnwick")
		};
		return emp;
	}
}
