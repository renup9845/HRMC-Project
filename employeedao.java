/**
 * The Operation of HR Management System to add Employee And Remove Employee from DataBase
 * Performing Salary Hike of One or All Employees
 * By Renu
 *
 */


package com.slot2jdbc;
import java.sql.*;
public class employeedao {
	
	Connection con = null;
	
	public void connect() throws Exception{
		
		//Getting Connection with DataBase
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","root");
		
		}
	       //Method To Add Employee
			public int  addEmployee(employee emp) throws Exception{
				String query ="select * from employee where empName = "+emp.ename+"'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				if(rs.next()) {
					return -1;
				}
				else {
					String query2 = "insert into employee (ename,edomain,edesignation,elocation,esal,ephone) values(?,?,?,?,?,?)"; 
					PreparedStatement pst = con.prepareStatement(query2);
				   
					pst.setString(1,emp.ename);
				    pst.setString(2,emp.edomain);
				    pst.setString(3,emp.edesignation);
				    pst.setString(4,emp.elocation);
				    pst.setInt(5,emp.esal);
				    pst.setString(6, emp.ephone);
				    int count = pst.executeUpdate();
				    
				    return count;
				}
				
				}
			   
				//Method To Delete Employee
			    public int removeEmployee(int id) throws Exception{
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from employee where eId="+id);
				
				if(rs.next()) {
					rs.close();
					Statement Deletest = con.createStatement();
					Deletest.executeUpdate("Delete from employee where eId="+id);
					return 1;
				
				}
				else {
					return 0;
				}
			    }
				
				//Method To Hike Salary of Employee
				public int hikeSalary(int id,int hike) throws Exception{
					
					Statement st = con.createStatement();
					
					//If Employee Exist
					ResultSet rs = st.executeQuery("select * from employee where eId="+id);
					
					if(rs.next()) {
						Statement hikest = con.createStatement();
						int salary = rs.getInt(6);
						salary = salary+((salary*hike)/100);
						
						//Updated Balance
						hikest.executeUpdate("Update employee set esal="+salary+" where eid="+id);
						return salary;
					}
					else
						return 0;
				
					
					}
				
				public int hikeAll(int hike) throws Exception{
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery("select * from employee");
					rs.next();
					
					Statement withdrawst = con.createStatement();
					
					withdrawst.executeUpdate("Update employee set esalary= esalary+(esalary*"+hike+"/100");
					return 1;
				}
			  }


