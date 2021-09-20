package com.bridgelabz.addressbookgradle;

import java.util.Scanner;

public class AddressBookMain {
	public static AddressBookList addressBookList = new AddressBookList();
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System");
		AddressBookMain addressBookMain = new AddressBookMain();
		Scanner sc = new Scanner(System.in);
		boolean exit1 = true;
		while(exit1) {
			System.out.println("Select option 1:Add address Book 2:open Address Book 3.Search in address book 4.Count of persons 5.sort contacts 6:Exit");
			switch(sc.nextInt()) {
			case 1: 
				System.out.println("Enter the address book name");
				String name = sc.next();
				AddressBook addressBook = new AddressBook();
				addressBookList.add(name, addressBook);
				break;
			case 2:
				System.out.println("Enter the name of Address Book");
				String book = sc.next();
				if(addressBookList.get(book)==null)
					System.out.println("Address Book does not exist");
				else {
					AddressBook bookName = addressBookList.get(book);
					addressBookList.addressMenu(bookName);
				}
				break;
			case 3:
				System.out.println("Options: 1.search by city 2:search by state");
				int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("Enter city name");
					addressBookList.searchAcrossByCity(sc.next());
				}
				else if(choice==2) {
					System.out.println("Enter state name");
					addressBookList.searchAcrossByState(sc.next());
				}
				else
					System.out.println("Invalid choice");
				break;
			case 4:
				System.out.println("Options: 1:Count by city 2.Count by state");
				int option = sc.nextInt();
				if(option==1)
					addressBookList.countByCity();
				else if(option==2)
					addressBookList.countByState();
				else
					System.out.println("Invalid choice");
				break;
			case 5:
				System.out.println("Options 1.by name 2. by zip 3.by city 4.by state");
				int ch=sc.nextInt();
				if(ch==1)
					addressBookList.sortByName();
				if(ch==2)
					addressBookList.sortByZip();
				if(ch==3)
					addressBookList.sortByCity();
				if(ch==4)
					addressBookList.sortByState();
				else
					System.out.println("Invalid choice");

				break;
			default:
				exit1 = false;

			}
		}

	}

	public static void addContact(AddressBook addressBook) {
		Scanner scannerObject=new Scanner(System.in);
		System.out.println("Enter contact details");
		System.out.println("Enter first name");
		String firstName = scannerObject.next();
		System.out.println("Enter last name");
		String lastName = scannerObject.next();
		System.out.println("Enter city");
		String city = scannerObject.next();
		System.out.println("Enter state");
		String state = scannerObject.next();
		System.out.println("Enter zip");
		String zip = scannerObject.next();
		System.out.println("Enter phone number");
		String phoneNumber = scannerObject.next();
		System.out.println("Enter email");
		String email = scannerObject.next();
		Contact contact = new Contact(firstName, lastName, city, state, zip, phoneNumber, email);
		addressBook.addContact(contact);
		
	}
	
}
