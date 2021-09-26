package com.bridgelabz.addressbookgradle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookDBService {

	public void readData() {
		String sql = "select * from contacts;";
		try(Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String id = result.getString("contact_id");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String phoneNumber = result.getString("phoneNumber");
				String email = result.getString("email");
				System.out.println("ID: "+id+" First Name: "+firstName+" Last Name: "+lastName+"  Phone Number"+phoneNumber+" email"+email+" ");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
		String userName = "root";
		String password = "Perfios@2021";
		Connection connection;
		System.out.println("connecting to database: "+jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("connection is successful!"+connection);
		return connection;
	}

}
