package com.medical.dao;	

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {
     public static void loginValidation(String email, String Password) throws SQLException, ClassNotFoundException
    	 {
    	  Connection connection=ConnectionUtil.databaseConnection();
    	  PreparedStatement statement =null;
    	  String query =" Select name,email, password from medicalShopApp_user where email= ?";
    	  statement=connection.prepareStatement(query);
    	  statement.setString(1, email);
    	  ResultSet result=statement.executeQuery();
    	  String password=null;
    	  String mail=null;
    	  String name=null;
    	  if(result.next())
    	  {
    		  name=result.getString("name");
    		  mail=result.getString("email");
    		  password=result.getString("password");
    		  }
    	  if(mail==null)
    	  {
    		  System.out.println("No records found");
    		  System.exit(1);
    	  }
    	  else if(Password.equals(password))
    	  {
    		  System.out.println("\nWelcome to medical shop");
    		  System.out.println("Nice to have you back "+name);
    	  }
    	  else if(!Password.equals(password))
    	  {
    		  System.out.println("Invalid credentials");
    		  System.out.println("Try again! "+name+" :(");
    		  System.exit(1);
    	  }
		
	}
}
