package com.navitha.jdbc;
import java.sql.*;
public class Jdbcdemo1 
{
	
			public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			//create a new table under the JdbcCrud database
			
			String sql_query = "create table Employee(EmpId int primary key auto_increment, EmpFirst_Name varchar(50) , EmpLast_Name varchar(50) , EmpAge int)";
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
			Statement st = con.createStatement();
			// to create a table with columns
			st.executeUpdate(sql_query);
			// to my refernace
			System.out.println("Table created successfully");
			con.close();
			
		}

}
