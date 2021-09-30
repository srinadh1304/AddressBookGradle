package com.bridgelabz.addressbookgradle;


import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bridgelabz.addressbookgradle.AddressBookList.IOService;

public class AddressBookTest {
	

	static AddressBook addressBook = new AddressBook();
	
	
	@Test
	public void givenDetails_ShouldAddToContactList() {
		
		Contact person = new Contact("Srinadh","t","Tenali","Andhra","522201","9290090032","srinadh@gmail.com");
		addressBook.addContact(person);
		Contact person2 = new Contact("Chandra","t","Tenali","Andhra","522201","8463934331","chandra@gmail.com");
		addressBook.addContact(person2);
		List<Contact> contact = new LinkedList<>();
		contact.add(person);
		contact.add(person2);
		AddressBookIo addressBookIO = new AddressBookIo();
		addressBookIO.writeData(contact);
		Assert.assertEquals(2, addressBookIO.countEntries());
	}
	@Test
	public void givenAddressBookInDB_WhenRetrived_ShouldReturnCount()
	{
		AddressBookDBService addressBook = new AddressBookDBService();
		long count  = addressBook.readData();
		Assert.assertEquals(8, count);
	}
	
	
	@Test
	public void givenACity_WhenQueried_ShouldGetNumberOfContacts()
	{
		AddressBookDBService addressBook = new AddressBookDBService();
		int count  = addressBook.getNumberOfContactsInACity("Bengaluru");
		Assert.assertEquals(5, count);
	}
	
	
}
