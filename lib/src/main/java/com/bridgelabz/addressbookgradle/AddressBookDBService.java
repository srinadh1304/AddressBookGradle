package com.bridgelabz.addressbookgradle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AddressBookDBService {
	private PreparedStatement addressBookPreparedStatement;
	private static AddressBookDBService addressBookDBService;
	AddressBookDBService() {}
	
	public long readData() {
		String sql = "select * from address_book;";
		long count=0;
		try(Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String phoneNumber = result.getString("phoneNumber");
				String email = result.getString("email");
				System.out.println(" First Name: "+firstName+" Last Name: "+lastName+"  Phone Number"+phoneNumber+" email"+email+" ");
				count=count+1;
				
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service_old?useSSL=false";
		String userName = "root";
		String password = "Perfios@2021";
		Connection connection;
		System.out.println("connecting to database: "+jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("connection is successful!"+connection);
		return connection;
	}
	
	public int getNumberOfContactsInACity(String city) {
		int count = 0;
		if(this.addressBookPreparedStatement == null) {
			this.prepareStatementForAddressBook();
		}
		try {
			addressBookPreparedStatement.setString(1, "Bengaluru");
			ResultSet resultSet = addressBookPreparedStatement.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt("count"); 
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new AddressBookException(AddressBookException.ExceptionType.CANNOT_EXECUTE_QUERY, "Failed to execute query");
		}
		return count;
	}
	
	private void prepareStatementForAddressBook() {
		try {
			Connection connection = this.getConnection();
			String sqlStatement = "SELECT city,count(*) as 'count' FROM address_book WHERE city = ? GROUP BY city;";
			addressBookPreparedStatement = connection.prepareStatement(sqlStatement);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
