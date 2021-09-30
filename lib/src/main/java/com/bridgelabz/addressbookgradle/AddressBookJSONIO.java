package com.bridgelabz.addressbookgradle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class AddressBookJSONIO {
	public static String ADDRESSBOOK_JSON_FILE_NAME = "AddressBook-JSON.json";
	public void writeDatatoJSON(List<Contact> addressBook) {
		Gson gson = new Gson();
		String json = gson.toJson(addressBook);
		FileWriter writer;
		try {
			writer = new FileWriter(ADDRESSBOOK_JSON_FILE_NAME);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void readDataFromJSON() {
		Gson gson = new Gson();
		List<Contact> contactList = new ArrayList<Contact>();
		BufferedReader bufferObject;
		try {
			bufferObject = new BufferedReader(new FileReader(ADDRESSBOOK_JSON_FILE_NAME));
			Contact[] addressBookData = gson.fromJson(bufferObject, Contact[].class);
			contactList = Arrays.asList(addressBookData);
			for (Contact contact : contactList) {
				System.out.println("First Name: "+contact.getFirstName());
				System.out.println("Last Name: "+contact.getLastName());
				System.out.println("City: "+contact.getCity());
				System.out.println("State: "+contact.getState());
				System.out.println("Zip: "+contact.getZip());
				System.out.println("Phone number: "+contact.getPhoneNumber());
				System.out.println("Email: "+contact.getEmail());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
