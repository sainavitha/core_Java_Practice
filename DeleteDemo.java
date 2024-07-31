package com.navitha.jdbc;
import java.sql.*;
public class DeleteDemo 
{
	public static void main(String[] args) throws Exception{
		  Class.forName("com.mysql.cj.jdbc.Driver");	
		 
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
			
			Statement st = con.createStatement();
			
			//deleting the records
			
			String delete_table = "drop table Employee";
			
			int delete_record_row = st.executeUpdate(delete_table);
			System.out.println("Deleting the table done successfully");
			
			con.close();


}
}
