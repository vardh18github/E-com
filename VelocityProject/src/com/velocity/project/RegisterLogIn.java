package com.velocity.project;

//Customer can register and login 


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class RegisterLogIn 
{
	String name,email,mob,pass1,pass2;
	int custId;
	//int custId;
	
	int count=0;
	public void getRegister()
	{
		PreparedStatement stmt = null;
		Connection connection = null;			
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Register\n2.Login");
		int i=sc.nextInt();
		if(i==1)
		{
			System.out.println("Enter your name:");
			name=sc.next();			
			System.out.println("Enter your Mobile No:");
			mob=sc.next();
			System.out.println("Enter your EmailID:");
			email=sc.next();					
			System.out.println("Enter Password:");
			pass1=sc.next();			
			System.out.println("Re-enter Password:");
			pass2=sc.next();
			try
			{
				String sql="insert into customer(custName,custEmail,custMobile,custPassword) values(?,?,?,?)";
				ProductList pl=new ProductList();		
				connection=pl.getConnectionDetails();
				stmt=connection.prepareStatement(sql);
				stmt.setString(1,name);
				stmt.setString(2,email);
				stmt.setString(3,mob);
				if(pass1.equals(pass2)) 
				{
					stmt.setString(4,pass1);
				}
				else
				{
					System.out.println("Password not matched. Please try again.");
					System.out.println("Enter Password:");
					String pass1=sc.next();			
					System.out.println("Re-enter Password:");
					String pass2=sc.next();
					stmt.setString(4,pass1);
				}
				int j=stmt.executeUpdate();
				System.out.println("You are registered successfully..");
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}	
		
		}

	
	/*public void getLogIn() throws SQLException
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
		int count=0;
		
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
					//System.out.println(custId);
					pl.displayProductList();					
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
	
		if(count==1)
		{
			System.out.println("Invalid credentials.");
			RegisterLogIn regLog=new RegisterLogIn();
			regLog.getLogIn();
		}
		
	}*/
	
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
					//System.out.println(custId);
					pl.displayProductList();					
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
