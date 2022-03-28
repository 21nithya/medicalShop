package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.medical.model.*;

public class RegistrationDAO {
	public static void addUser (Registration medicalClass)throws Exception {
// getting connection from conectionUtil Class
		Connection connection = ConnectionUtil.databaseConnection();
//		System.out.println(connection);// getting query from user
		String query = "insert into medicalShopApp_user (NAME, email, password,contact) values (?,?,?,?)" ;
		PreparedStatement statement=connection. prepareStatement(query);// preparedStatement = ?
		//statement.setString(1, medicalClass.getId());
		// whats happening  = ?
		statement.setString(1, medicalClass.getName());
		statement.setString(2, medicalClass.getEmail());
		statement.setString(3, medicalClass.getPassword());
		statement.setString(4, medicalClass.getContact());
//		System.out.println(query);
		int row=statement.executeUpdate();
		System.out.println("Hi"+medicalClass.getName());
//		System.out.println("No of rows inserted:" +row);
		statement.close();
		connection.close();
		
		
	}
	// validateUser = method name
	public static void validateUser(String email) throws Exception {
		Connection connection = ConnectionUtil.databaseConnection();
		String mail=null;// declaring that string must not be null
		
		String query="select email from medicalShopApp_user where email='"+email+"'";// it is not null i am going to check mail from the table 

		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery(query);// ResultSet = ? ,rs = object name , creating an object to store that query

		if(rs.next()) {
			mail=rs.getString("email");// next = ?
		}
		if(mail==null) {
			System.out.println("New User!");
		}
		else {
			throw new Exception("You're an existing user !");
		}
		
	}

		
	}
