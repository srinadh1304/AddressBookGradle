package com.bridgelabz.addressbookgradle;

public class Address {
	
	private int contact_id;
	private String address;
	private String city;
	private String state;
	private int zip;
	
	public Address(int contact_id, String address, String city, String state, int zip) {
		super();
		this.contact_id = contact_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
