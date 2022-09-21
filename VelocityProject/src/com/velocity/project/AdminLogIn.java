package com.velocity.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogIn 
{
	public void AdminAccount() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Buyer\n2.Admin");
		int i=sc.nextInt();
		if(i==1)
		{
			//RegisterLogIn regLog=new RegisterLogIn();
			//regLog.getRegister();
			//regLog.getLogIn();
			//regLog.validUser();
		}
		else
		{
			AdminLogIn adminLog=new AdminLogIn();
			adminLog.ifAdmin();
		}
	}
	
	
	void ifAdmin() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id");
		String regId=sc.next();
		System.out.println("Enter Password");
		String regPass=sc.next();
		PreparedStatement stmt = null;
		Connection connection = null;
		ResultSet rs= null;
		int count=0;
		
		try
		{
			String sql="select * from user";	
			//ProductList pl=new ProductList();		
			//connection=pl.getConnectionDetails();
			stmt=connection.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				if(regId.equals(rs.getString(1)) && regPass.equals(rs.getString(2)))
				{					
					count=0;
					adminChoice();
					break;
				}else
				{
					count=1;
				}
				
			}

		}catch(Exception e)
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
			AdminLogIn regUser=new AdminLogIn();
			regUser.AdminAccount();
		}
	}
	
	void adminChoice() throws SQLException
	{	
	System.out.println("Enter your choice:");
	System.out.println("1.Entire User List\n2.Check product quatity by using product id\n3.Product purchase details");
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	if(a==1)
	{
		//RegisterUserList regUserList=new RegisterUserList();
		//regUserList.getRegisterUserList();	
		continueOrQuit();
	}
	else if(a==2)
	{
		//AdminProductList adminProductList=new AdminProductList();
		//adminProductList.getProductListById();
		continueOrQuit();
	}
	else if(a==3)
	{
		//ProductPurchaseDetails productPurchase=new ProductPurchaseDetails();
		//productPurchase.purchaseDetails();
		continueOrQuit();
	}
	}
	
	public void continueOrQuit()
	{
		Scanner sc=new Scanner(System.in);
	
		try {
			
			System.out.println("1.Continue\n2.Quit");
			int i=sc.nextInt();
			if(i==1)
			{
				adminChoice();
			}
			else
			{
				System.out.println("You are exited");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}	

