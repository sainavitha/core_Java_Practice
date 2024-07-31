package com.navitha.jdbc;
import java.sql.*;
public class UpdateDemo 
{
	public static void main(String[] args) throws Exception{
		  Class.forName("com.mysql.cj.jdbc.Driver");	
		 
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
			
			Statement st = con.createStatement();
				
			String update_query = "update Employee set EmpAge=48 , EmpDesignation = 'Manager' where EmpLast_Name='Smith'";
			
			System.out.println("Updating the records done successfully");
			int updateCount_row = st.executeUpdate(update_query);
			System.out.println("the number rows updated :"+updateCount_row);
			
			con.close();
			
	}

}
