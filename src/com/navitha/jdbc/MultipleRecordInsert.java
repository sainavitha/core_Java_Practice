package com.navitha.jdbc;
import java.sql.*;
import java.util.Scanner;
public class MultipleRecordInsert
{
	public static void main(String[] args) throws Exception{
		 Class.forName("com.mysql.cj.jdbc.Driver");	
				
//				String jdbc_url = "jdbc:mysql://localhost:3306/navitha";
//				String user = "root";
//				String pwd="root";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
				
				Statement st = con.createStatement();
				
				// to ask MultipleRecord and insert from the user / keyboard
				
				Scanner sc = new Scanner(System.in);
				
				while(true)
				{
				System.out.println("Enter the EmpId :");
				int EmpId = sc.nextInt();
				
				System.out.println("Enter the EmpFirst_Name :");
				String EmpFirst_Name = sc.nextLine();
				
		
				System.out.println("Enter the EmpLast_Name :");
				String EmpLast_Name = sc.nextLine();
				
				System.out.println("Enter the EmpAge :");
				int EmpAge = sc.nextInt();
				// String formating to store different datatype and multi records
				String insert_data = String.format("insert into Employee values(%d,'%s','%s',%d)",EmpId,EmpFirst_Name,EmpLast_Name,EmpAge);
				
				
				st.executeUpdate(insert_data);
				System.out.println("Record inserted  successfully ... !");
				
				System.out.println("!------ Do u want to insert or add one more employee record [Yes/No]:----!");
				
				String option = sc.next();
				if(option.equalsIgnoreCase("No"))
				{
					System.out.println("Stop this process");
					break;
					
				}
				}
				
				con.close();
				
				
				
				
				
				
			}

}
