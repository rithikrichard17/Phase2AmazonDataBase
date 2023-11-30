package com.Amazon.qa.AmazonDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcAmazonInventory {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		// This is DB connection string
		
		String dburl = "jdbc:mysql://localhost:3306/amazon_product";
		String username = "root";
		String password = "1234";
		String query = "select * from amazon_inventory";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dburl,username,password);
		Statement stmt = con.createStatement(); // execute query
		ResultSet rs = stmt.executeQuery(query); 
		// see the result
	
		while(rs.next()) {
			
			System.out.print("ProductName: " + rs.getString("productname") + "\t");
			System.out.print("ProductID: " + rs.getString("productid") + "\t");
			System.out.print("ProductStock: " + rs.getString("productstock"));
		}
		
		
		
		

	}

}