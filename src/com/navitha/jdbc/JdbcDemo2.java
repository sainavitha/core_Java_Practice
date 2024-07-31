package com.navitha.jdbc;
import java.sql.*;
public class JdbcDemo2 
{public static void main(String[] args) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");	
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
	
	Statement st = con.createStatement();
	ResultSet rs =st.executeQuery("select * from Employee");
	while(rs.next())
	{
		//System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6));
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
	}
	con.close();
	
}


}
