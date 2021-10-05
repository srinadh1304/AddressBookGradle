package com.bridgelabz.addressbookgradle;

public class Contact {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String date_added;
	public String getDate_added() {
		return date_added;
	}
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	public Contact(String firstName, String lastName, String phoneNumber, String email,String date_added) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.date_added=date_added;
	}
	public Contact(String firstName, String lastName, String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
