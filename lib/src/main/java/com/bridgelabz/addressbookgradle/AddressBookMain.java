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
			System.out.println("Select option 1:Add address Book 2:open Address Book 3.Search in address book 5.sort contacts3:Exit");
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
			case 5:
				addressBookList.sortContacts();
			default:
				exit1 = false;

			}
		}

	}
	
}
