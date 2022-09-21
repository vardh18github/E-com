package com.velocity.project;

//Admin able to display customer's list who are registered


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterUserList {
	
	void getRegisterUserList() 
	{
		PreparedStatement stmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		try {
			String str = "Select * from customer order by custName ASC";
			ProductList pl=new ProductList();		
			connection=pl.getConnectionDetails();
			stmt=connection.prepareStatement(str);
		      rs=stmt.executeQuery();
		      System.out.println("Register User List>");
		      System.out.println("\n\ncustID\t\tcustName\tcustEmail\t\tCustMobile\n");
				while(rs.next())
				{
					System.out.print(rs.getInt(1)+"\t\t");
					System.out.print(rs.getString(2)+"\t\t");
					System.out.print(rs.getString(3)+"\t\t");
					System.out.print(rs.getString(4)+"\t\t\t");
					System.out.println("\n");
				}
		      
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

