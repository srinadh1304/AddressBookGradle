package com.bridgelabz.addressbookgradle;

import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.addressbookgradle.IOServiceEnum.IOService;


public class AddressBookDBTest {
	@Test
	public void givenContactsInDB_WhenRetrieved_ShouldMatchContactCount(){
		AddressBookDBService addressBookService = new AddressBookDBService();
		long contactList = addressBookService.readData();
		System.out.println(contactList);
		Assert.assertEquals(6, contactList);
	}
	@Test
	public void givenAContact_WhenInserted_IntoContact_ShouldGetUpdatedSize()
	{
		String date1 = "2018-01-02";
		ContactPojo contactObject=new ContactPojo("chandra", "t", "8463934331", "chandra@gmail.com",date1);
		AddressBookDBService addressBook = new AddressBookDBService();
		long initialSize  = addressBook.readData();
		addressBook.writeIntoContact(contactObject);
		Assert.assertEquals(initialSize+1, 7);
	}
	@Test
	public void givenContactIdAndPhonenumber_WhenUpdated_shouldReturnOne()
	{
		AddressBookDBService addressBook = new AddressBookDBService();
		addressBook.readData();
		int count=addressBook.updatePhonenumberOfContact("9290090032", 1);
		Assert.assertEquals(1,count);
	}
	@Test
	public void givenDateRange_FindContactsAddedInThatRange_ShouldReturnCount() {
		AddressBookDBService addressBook = new AddressBookDBService();
		String date1 = "2017-08-02";
		String date2 = "2019-09-09";
		long count = addressBook.getEmployeeInADateRange(date1,date2);
		Assert.assertEquals(5, count);
	}
}
