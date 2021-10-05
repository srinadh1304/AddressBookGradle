package com.bridgelabz.addressbookgradle;

import com.bridgelabz.addressbookgradle.IOServiceEnum.IOService;;


public interface AddressBookInterface {
	public void writeDataToFile(IOService ioService);
	public void readDataFromFile();
	public void writeDataToCsvFile();
	public void readDataFromCsvFile();
	public void findContactInCity(String cityName);
	public void findContactInState(String stateName);
	public void sortByName();
	public void sortByCity();
	public void sortByZip();
	public void sortByState();
	public void editContact();
	public void deleteContact();
	public void addContact(Contact contact);
	public boolean checkIfContactExists(Contact contact);
	public void printCountByCity();
	public void printCountByState();
	public void writeDataToJson() ;
	public void readDataFromJson();
	
}
