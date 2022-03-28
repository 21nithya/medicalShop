package com.medical.dao;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.medical.model.*;


public class DisplayDAO {
	// creating list to store 
          public static  List<MedicalProducts> showALL() throws Exception {
 // storing all object      	  
        	  List<MedicalProducts> medicine=new ArrayList<MedicalProducts>();
        	  
        	  Integer id=0;
        	  String productName=null;
        	  String brandName=null;
        	  Integer price=0;
        	  
        	  
        	  String sql = " select * from medical_display";
        	  
        	  Connection connection= ConnectionUtil.databaseConnection();
        	  Statement statement = connection.createStatement();
  //functions
        	  ResultSet products = statement.executeQuery(sql);
        	  
// it will take table values of sql and compare  
        	  while(products.next()) {
        		  
 //it will take each values and store 
        		    id=products.getInt("product_id");
        		  	productName=products.getString("product_name");
        		  	brandName=products.getString("brand_name");
        		  	price=products.getInt("price");
   	  	
        		  	
 // it will convert stored values into object      		  	
//        		  	MedicalProducts items=new MedicalProducts(id,productName,brandName,price);
        		  	MedicalProducts items=new MedicalProducts();
        		  	items.setId(id);
        		  	items.setProductName(productName);
        		  	items.setBrandName(brandName);
        		  	items.setPrice(price);
        		  	
       		  	medicine.add(items);
        		
        	  }
// it will display all the values from medicine
        	  return medicine;
          }
}
