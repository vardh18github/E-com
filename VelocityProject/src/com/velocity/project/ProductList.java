package com.velocity.project;

//Tried to take custID in cart table(not working)-----

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoggedInUser 
{
	int custId;
	int count=0;
	
	int getLogIn() throws SQLException
	{
		System.out.println("Please Login");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email Id");
		String regEmail=sc.next();
		System.out.println("Enter Password");
		String regPass=sc.next();
		PreparedStatement stmt = null;
		Connection connection = null;
		ResultSet rs= null;	
		
		try
		{
			String sql="select * from customer";	
			ProductList pl=new ProductList();		
			connection=pl.getConnectionDetails();
			stmt=connection.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				if(regEmail.equals(rs.getString(3)) && regPass.equals(rs.getString(5)))
				{					
					count=0;
					custId=rs.getInt(1);
					break;
				}
				else
				{
					count=1;
				}				
			
			}					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally 
		{
			connection.close();
			stmt.close();
			rs.close();
		}
	
		return custId;
	
	}
	
	
	
void validUser() throws SQLException
{
	if(count==1)
	{
		System.out.println("Invalid credentials.");
		RegisterLogIn regLog=new RegisterLogIn();
		regLog.getLogIn();
	}
	else if(count==0)
	{
		ProductList pl=new ProductList();		
		pl.displayProductList();		
	}
}
	
}

