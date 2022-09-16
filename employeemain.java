/**
 * The Operation of HR Management System to add Employee And Remove Employee from DataBase
 * Performing Salary Hike of One or All Employees
 * By Renu
 *
 */


package com.slot2jdbc;
import java.util.Scanner;

public class employeemain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner bs = new Scanner(System.in);
		int eid,esal,choice = 0;
		String ename,edomain,edesignation,elocation,ephone;
		
		employeedao edao = new employeedao();
		
		edao.connect();
		
		while(choice<5) {
			System.out.println("\nPress 1 - Add Employee \nPress 2 - Hike Salary of an Employee \nPress 3 - Hike Salary of all Employee \nPress 4 - Remove Employee \nPress 5 - Exit");
			System.out.print("Select Operation : ");
			int op = bs.nextInt();
			
			switch(op) {
			
			//Add Employee
			case 1 ->{
				employee emp = new employee();
				System.out.print("Enter User Name : ");
				ename = bs.next();
				emp.ename = ename;
				System.out.print("Enter Domain : ");
				edomain = bs.next();
				emp.edomain = edomain;
				System.out.println("Enter Designation : ");
				edomain = bs.next();
				emp.edomain = edomain;
				System.out.println("Enter Location : ");
				elocation = bs.next();
				emp.elocation = elocation;
				System.out.print("Enter Phone No : ");
				ephone = bs.next();
				emp.ephone = ephone;
				System.out.println("Enter Salary : ");
				esal = bs.nextInt();
				emp.esal = esal;
				int set = employeedao.addEmployee(emp);
				if (set == 1)
					System.out.println("\nEmployee Added Successfully!!");
				else
					System.out.println("\nEmployee Already Exist");
				
				
				}
			
			//Hike Salary of an Employee
			case 2 ->{
				int amt,id;
				System.out.print("\nEnter Employee Id : ");
				id = bs.nextInt();
				System.out.print("\nEnter percentage for salary hike : ");
				amt = bs.nextInt();
				
				int ret = employeedao.hikeSalary(id,amt);
				if(ret>0) 
					System.out.println("\nUpdated Salary : "+ret);
				else
					System.out.println("\nEmployee does not exist!!");
				
				
				}
			
			//Hike salary of all Employees
			case 3 ->{
				System.out.print("\nEnter Percentage for Salry Hike : ");
				int amt = bs.nextInt();
				
				int ret = employeedao.hikeAll(amt);
				if(ret == 1)
					System.out.println("\nSalary Updated Successfully!!");
				else
					System.out.println("\nOops!! Something went Wrong!!");
				
			    }
			
			//Remove an Employee
			case 4 ->{
				int id;
				System.out.print("\nEnter Employee Id : ");
				id = bs.nextInt();
				
				int ret = employeedao.removeEmployee(id);
				if(ret == 1)
					System.out.println("Employee removed Successfully!!");
				else
					System.out.println("Employee does not Exist!!");
				
				
			}
			}
		  }
			
			//Close the Scanner Object
			bs.close();
		  }
      }
