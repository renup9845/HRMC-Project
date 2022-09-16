package com.slot2jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest{
	
	employeedao employee = new employeedao();
	
	employee emp = new employee() ;
	
	@Test
	void testAddEmployee() throws Exception {
		employee.connect();
		emp.ename = "Renu";
		emp.edomain = "Java";
		emp.edesignation = "Developer";
		emp.elocation = "Faridabad";
		emp.ephone = "9643025686";
		emp.esal = 35000;
		
		assertEquals(-1,employee.addEmployee(emp));
		
		emp.ename = "Kunal";
		emp.edomain = ".net";
		emp.edesignation = "Developer";
		emp.elocation = "Noida";
		emp.ephone = "8800546959";
		emp.esal = 40000;
		
		assertEquals(1,employee.addEmployee(emp));
		
	
	}
	
	@Test
	void testHikeSalary() throws Exception{
		employee.connect();
		
		assertEquals(35400,employee.hikeSalary(102,15));
		
		assertEquals(0,employee.hikeSalary(109,20));
		
	}
	
	@Test
	void testRemoveEmployee() throws Exception{
		
		employee.connect();
		
		assertEquals(0,employee.removeEmployee(108));
		
		assertEquals(1,employee.removeEmployee(110));
	}
	
	
	
	
		
	}
