package com.bridgelabz.addressbookgradle;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.addressbookgradle.IOServiceEnum.IOService;
import com.google.gson.Gson;;

public class AddressBookIOTest {
	

	static AddressBook addressBook = new AddressBook();
	
	
	@Test
	public void givenContactDetails_ShouldAddToContactList() {
		
		Contact person = new Contact("Srinadh","t","Tenali","Andhra","522201","9290090032","srinadh@gmail.com");
		addressBook.addContact(person);
		Contact person2 = new Contact("Chandra","t","Tenali","Andhra","522201","8463934331","chandra@gmail.com");
		addressBook.addContact(person2);
		List<Contact> contact = new LinkedList<>();
		contact.add(person);
		contact.add(person2);
		AddressBookFileIO addressBookIO = new AddressBookFileIO();
		addressBookIO.writeData(contact);
		Assert.assertEquals(2, addressBookIO.countEntries());
	}
	@Test
	public void givenContacts_ShouldAddToTextFile() {
		Contact contact1 = new Contact("Srinadh","t","Tenali","Andhra","522201","9290090032","srinadh@gmail.com");
		addressBook.addContact(contact1);
		Contact contact2 = new Contact("Chandra","t","Tenali","Andhra","522201","8463934331","chandra@gmail.com");
		addressBook.addContact(contact2);
		
		AddressBook book1 = new AddressBook();
		book1.addContact(contact1);
		book1.addContact(contact2);
		book1.writeDataToFile(IOService.FILE_IO);
		long size=0;
		try {
			size = Files.lines(Paths.get(AddressBookFileIO.ADDRESSBOOK_FILE_NAME)).count();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(2,size);		
	}
	@Test
	public void givenContacts_ShouldAddToCSVFile() {
		Contact contact1 = new Contact("Srinadh","t","Tenali","Andhra","522201","9290090032","srinadh@gmail.com");
		addressBook.addContact(contact1);
		Contact contact2 = new Contact("Chandra","t","Tenali","Andhra","522201","8463934331","chandra@gmail.com");
		addressBook.addContact(contact2);
		
		AddressBook book1 = new AddressBook();
		book1.addContact(contact1);
		book1.addContact(contact2);
		book1.writeDataToFile(IOService.CSV_IO);
		long size=0;
		try {
			size = Files.lines(Paths.get(AddressBookCSVIO.ADDRESSBOOK_CSV_FILE_NAME)).count();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(2,size);		
	}
	@Test
	public void givenContacts_ShouldAddToJSONFile() {
		Contact contact1 = new Contact("Srinadh","t","Tenali","Andhra","522201","9290090032","srinadh@gmail.com");
		addressBook.addContact(contact1);
		Contact contact2 = new Contact("Chandra","t","Tenali","Andhra","522201","8463934331","chandra@gmail.com");
		addressBook.addContact(contact2);
		
		AddressBook book1 = new AddressBook();
		book1.addContact(contact1);
		book1.addContact(contact2);
		book1.writeDataToFile(IOService.JSON_IO);
		long size=0;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(AddressBookJSONIO.ADDRESSBOOK_JSON_FILE_NAME));
			Contact[] usrObj = gson.fromJson(br, Contact[].class);
			List<Contact> csvUSerList = Arrays.asList(usrObj);
			size = csvUSerList.size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(2,size);		
	}
}
