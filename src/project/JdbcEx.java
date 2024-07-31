package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//step 1 register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
        //step 2 Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kiladi","root","root");
		System.out.println("connection created");
		 // Step 3: Create a statement
        Statement st = con.createStatement();

        // Step 4: Execute a query
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        // Step 5: Process the result set
        System.out.println("Stu_Id\\First_Name\\Last_Name\\DateOfBirth\\Gender\\Email\\phone");
        System.out.println("-----------------------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("Stu_Id") + "\t" +
                               rs.getString("First_Name") + "\t" +
                               rs.getString("Last_Name") + "\t" +
                               rs.getDate("DateOfBirth") + "\t" +
                               rs.getString("Gender") + "\t" +
                               rs.getString("Email") + "\t" +
                               rs.getString("phone"));
        }

        // Step 6: Close the resources
        rs.close();
        st.close();
        con.close();;
}

		
		
	}


