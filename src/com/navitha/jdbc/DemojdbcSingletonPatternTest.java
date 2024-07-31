
package com.navitha.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
    class DemojdbcSingletonPattern 
{
	
	
		
		// step1: creating the singleton class
		
		private static DemojdbcSingletonPattern jdbc;
		
		// constructor
		  private DemojdbcSingletonPattern() {
			 
		  }
		 
		 // to make the global access
		 
		  public static DemojdbcSingletonPattern getInstance()
		  {
			  if(jdbc== null)
			  {
				  jdbc = new DemojdbcSingletonPattern();
			  }
			  return jdbc;
		  }
		 
		 
		 
		private static Connection getConnection() throws ClassNotFoundException,SQLException {
			// TODO Auto-generated method stub
			Class.forName("com.mysql.cj.jdbc.Driver");	
			//create a new table under the JdbcCrud database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navitha","root","root");
			return con;
		}
		
		//to insert the record into the database
		 public int insert(String name, String pass) throws SQLException
		 {
		 Connection c=null;
		
		PreparedStatement ps=null;
		
		int recordCounter=0;
		
		try {
		
		 c=this.getConnection();
		 ps=c.prepareStatement("insert into userlogin(username,password)values(?,?)");
		ps.setString(1, name);
		ps.setString(2, pass);
		recordCounter=ps.executeUpdate();
		
		 }
		catch (Exception e)
		{
			e.printStackTrace();
		 }
		finally{
		 if (ps!=null){
		 ps.close();
		 }if(c!=null){
		c.close();
		 }
		 }
		 return recordCounter;
		 }
		//to view the data from the database
		 public void view(String name) throws SQLException
		 {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		try {
		con=this.getConnection();
		ps=con.prepareStatement("select * from userlogin where username=?");
		ps.setString(1, name);
		rs=ps.executeQuery();
		while (rs.next()) {
		System.out.println("Name= "+rs.getString(1)+"\t"+"Paasword= "+rs.getString(2));
		
		 } 
		 }
		catch (Exception e) { System.out.println(e);}
		 finally{
		 if(rs!=null){
		 rs.close();
		}
		if (ps!=null){
		 ps.close();
		 }if(con!=null){
		con.close();
		 }
		}
		}
		// to update the password for the given username
		 public int update(String name, String password) throws SQLException {
		 Connection c=null;
		PreparedStatement ps=null;
		 int recordCounter=0;
		try {
		 c=this.getConnection();
		 ps=c.prepareStatement(" update userLogin set username=? where username='"+name+"' ");
		ps.setString(1, password);
		recordCounter=ps.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); } finally{
		
		if (ps!=null){
		 ps.close();
		}if(c!=null){
		c.close();
		 }
		}
		 return recordCounter;
		 }
		
		// to delete the data from the database
		 public int delete(int userid) throws SQLException{
		 Connection c=null;
		 PreparedStatement ps=null;
		 int recordCounter=0;
		 try {
		 c=this.getConnection();
		 ps=c.prepareStatement(" delete from userLogin where uid='"+userid+"' ")
		 ;
		 recordCounter=ps.executeUpdate();
		 } catch (Exception e) { e.printStackTrace(); }
		 finally{
		 if (ps!=null){
		  ps.close();
		 }if(c!=null){
		 c.close();
		 }
		 }
		 return recordCounter;
		 }
		
	}
	public class DemojdbcSingletonPatternTest {
		 static int choice ; /// not instance it's static
		 static int count = 1; //optional
		public static void main(String[]args) throws Exception
		{
			
			// object will create only once for jdbc the instance
			DemojdbcSingletonPattern jdbc = DemojdbcSingletonPattern.getInstance();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// do while loop here
			do {
				System.out.println("CRUD operation:");
				System.out.println("===============================");
				System.out.println("Press 1 : for Insertion:");
				System.out.println("Press 2 : for display or view:");
				System.out.println("Press 3 : for delete :");
				System.out.println("Press 4 : for update :");
				System.out.println("Press 5 : for stop or Exit:");
				System.out.println("===============================");
				System.out.println("Pls enter above any one of u r choice:");
				choice =Integer.parseInt(br.readLine());
				switch(choice)
				{
					case 1:{
						System.out.println("Enter the user name u want to insert:");
						String username = br.readLine();
						
						System.out.println("Enter the password u want to insert:");
						String password = br.readLine();
						try {
							int i = jdbc.insert(username, password);
							if(i>0)
							{
								System.out.println((count++)+"Number of data inserted successfully");
							}
							else {
									System.out.println("Not inserted ");
								}
							}
						catch(Exception e)
						{
							System.out.println(e);
						}
						System.out.println("Press other key to continue process ....!");
						System.in.read();// next choice i want to collect
						
					} // case 1 completed
					break; // stop the process if press 5
					
					
					
					
					case 2 :{
						System.out.println("Enter user name :");
					String username = br.readLine();
					try {
						jdbc.view(username);
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					System.out.println("Press other key to continue process ....!");
					System.in.read();// next choice i want to collect
					}// case 2 completed
					break;
					
					
					
					case 3:{
						System.out.println("Enter the useId: want to delete:");
					int userid = Integer.parseInt(br.readLine());
					
					try {
						int i = jdbc.delete(userid);
						if(i>0)
						{
							System.out.println((count++)+"Number of data deleted successfully");
						}
						else {
								System.out.println("Not deleted...! ");
							}
						}
					catch(Exception e ) {
						System.out.println(e);
					
						}
					System.out.println("Press other key to continue process ....!");
					System.in.read();// next choice i want to collect
					}// case 3 completed
					break;
					
					
					case 4 :{
						System.out.println("Enter username , u want to update :");
						String username = br.readLine();
						System.out.println("Pls Enter new password:");
						String password = br.readLine();
						
						try{
							int i = jdbc.update(username, password);
							if(i>0)
							{
								System.out.println((count++)+"Number of data updated successfully");
							}
							else{
									System.out.println("Not updated...! ");
								}
						}
							catch(Exception e)
							{
								System.out.println(e);
							}
						
							System.out.println("Press other key to continue process ....!");
							System.in.read();// next choice i want to collect
							}// case 4 completed
							break;
							// above are worked
							default:
								return;
						
					}
			}
				while(choice!=4);
				
				}
				
	}


