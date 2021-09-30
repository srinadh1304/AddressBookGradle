package com.bridgelabz.addressbookgradle;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.addressbookgradle.IOServiceEnum.IOService;


public class AddressBookDBTest {
	@Test
	public void givenContactsInDB_WhenRetrieved_ShouldMatchContactCount(){
		AddressBookDBService addressBookService = new AddressBookDBService();
		String tableName="contacts";
		long contactList = addressBookService.readData();
		System.out.println(contactList);
		Assert.assertEquals(6, contactList);
	}
	@Test
	public void givenAContact_WhenInserted_IntoContact_ShouldGetUpdatedSize()
	{
		ContactPojo contactObject=new ContactPojo("chandra", "t", "8463934331", "chandra@gmail.com");
		AddressBookDBService addressBook = new AddressBookDBService();
		String tableName="contacts";
		long initialSize  = addressBook.readData();
		addressBook.writeIntoContact(contactObject);
		long updatedSize = addressBook.readData();
		Assert.assertEquals(initialSize+1, updatedSize);
	}
}
