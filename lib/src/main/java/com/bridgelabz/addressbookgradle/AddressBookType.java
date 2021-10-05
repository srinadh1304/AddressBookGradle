package com.bridgelabz.addressbookgradle;

public class AddressBookType {
	private String addressBook_name;
	private String addressBook_type;
	private int contact_id;
	public AddressBookType(String addressBook_name, String addressBook_type, int contact_id) {
		super();
		this.addressBook_name = addressBook_name;
		this.addressBook_type = addressBook_type;
		this.contact_id = contact_id;
	}
	public String getAddressBook_name() {
		return addressBook_name;
	}
	public void setAddressBook_name(String addressBook_name) {
		this.addressBook_name = addressBook_name;
	}
	public String getAddressBook_type() {
		return addressBook_type;
	}
	public void setAddressBook_type(String addressBook_type) {
		this.addressBook_type = addressBook_type;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	
}
