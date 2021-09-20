package com.bridgelabz.addressbookgradle;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIo {

	public static String ADDRESSBOOK_FILE_NAME = "AddressBook-file.txt";

	public void writeData(List<Contact> contacts) {
		
		StringBuffer addressBuffer = new StringBuffer();
		contacts.forEach(contact -> {
			String addressDataString = contact.toString();
			addressBuffer.append(addressDataString);
		});

		try {
			Files.write(Paths.get(ADDRESSBOOK_FILE_NAME), addressBuffer.toString().getBytes());

		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public long countEntries() {
		
		long entries=0;
		try {
			entries = Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath()).count();
		}
		catch(IOException e) {e.printStackTrace();};
		return entries;
	}
	public void printData() {
		
		try {
			Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath()).forEach(System.out::println);
		}
		catch(IOException e) {e.printStackTrace();}
		
	}

	public List<String> readDataFromFile() {
		
		List<String> addressBookList = new ArrayList<String>();
		
		try {
			Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath())
				.map(contact -> contact.trim())
				.forEach(contact -> {
					System.out.println(contact);
					addressBookList.add(contact);
			});
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return addressBookList;
	}
}
