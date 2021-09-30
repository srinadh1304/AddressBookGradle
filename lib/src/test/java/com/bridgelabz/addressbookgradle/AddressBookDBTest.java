package com.bridgelabz.addressbookgradle;

import org.junit.Assert;
import org.junit.Test;


public class AddressBookDBTest {
	@Test
	public void givenContactsInDB_WhenRetrieved_ShouldMatchContactCount(){
		AddressBookDBService addressBookService = new AddressBookDBService();
		long contactList = addressBookService.readData();
		System.out.println(contactList);
		Assert.assertEquals(8, contactList);
	}
}
