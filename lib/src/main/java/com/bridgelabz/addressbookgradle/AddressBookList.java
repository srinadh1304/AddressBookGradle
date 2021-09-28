package com.bridgelabz.addressbookgradle;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookList {
	public enum IOService {
		CONSOLE_IO, FILE_IO, CSV_IO,JSON_IO,DB_IO
	}
	private static HashMap<String, AddressBook> addressBooks;
	public AddressBookList() {
		this.addressBooks = new HashMap<>();
	}
	public void add(String name, AddressBook addressBook) {
		addressBooks.put(name,addressBook);
		
	}
	public AddressBook get(String book) {
		return addressBooks.get(book);
	}
	public void searchAcrossByCity(String city) {
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.findContactInCity(city);
		}
	}
	
	public void searchAcrossByState(String state) {
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.findContactInState(state);
		}
	}
	public void countByState() {
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.printCountByState();
		}
		
	}


	public void countByCity() {
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.printCountByCity();
		}		
	}
	
	public static void addressMenu(AddressBook addressBook) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		while(exit) {
			System.out.println("Select option \n1: Add Contact.  \n2: Edit Existing Contact. \n3: Delete contact.\n4: Write data\n5. Read data \n6. Exit");
			option  = sc.nextInt();
			switch(option) {
			case 1 :
				AddressBookMain.addContact(addressBook);
				break;
			case 2 :
				System.out.println("Enter the details to edit");
				addressBook.editContact();
				break;
			case 3:
				System.out.println("Enter the details to edit: ");
				addressBook.deleteContact();
				break;
			case 4:
				System.out.println("Enter \n1.To console\n2.To text file \n3.To CSV file \n4.To json file");
				int choice = sc.nextInt();
				if(choice==1)
					addressBook.writeDataToFile(IOService.CONSOLE_IO);
				else if(choice==2)
					addressBook.writeDataToFile(IOService.FILE_IO);
				else if(choice==3)
					addressBook.writeDataToFile(IOService.CSV_IO);
				else 
					addressBook.writeDataToFile(IOService.JSON_IO);
				break;
			case 5:
				System.out.println("Enter \n1.From text file \n2.from csv file \n3.from json file");
				int opt=sc.nextInt();
				if(opt==1)
					addressBook.readDataFromFile();
				else if(opt==2)
					addressBook.readDataFromCsvFile();
				else
					addressBook.readDataFromJson();
				break;
			
			default:
				exit = false;

			}
			System.out.println();
		}
	}
	public void sortByName() {		
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.sortByName();
		}
	}
	public void sortByZip() {		
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.sortByZip();
		}
	}
	public void sortByCity() {		
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.sortByCity();
		}
	}
	public void sortByState() {		
		for(AddressBook addressBook : addressBooks.values()) {
			addressBook.sortByName();
		}
	}
}