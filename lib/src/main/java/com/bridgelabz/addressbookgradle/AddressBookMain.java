package com.bridgelabz.addressbookgradle;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome to address book system");
		AddressBook addressBook = new AddressBook();
		addressBook.addContact();
		addressBook.editContact();	}

}
