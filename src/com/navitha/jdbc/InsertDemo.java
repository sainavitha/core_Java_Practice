package com.navitha.jdbc;

import java.sql.*;
public class InsertDemo {
    public static void main(String[] args) {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String jdbc_url = "jdbc:mysql://localhost:3306/navitha";
            String user = "root";
            String pwd = "root";

            // Establish the connection
            Connection con = DriverManager.getConnection(jdbc_url, user, pwd);

            // Create a statement object
            Statement st = con.createStatement();

            // Inserting the record
            String insert_data = "INSERT INTO Employee (EmpFirst_Name, EmpLast_Name, EmpAge) VALUES ('John', 'Doe', 30)";

            // Execute the insert statement
            int updateCount_row = st.executeUpdate(insert_data);

            // Print the number of rows inserted
            System.out.println("The number of rows inserted: " + updateCount_row);

            // Close the connection
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

	
