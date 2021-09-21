package com.bridgelabz.addressbookgradle;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.util.Arrays;

public class AddressBookIo {

	public static String ADDRESSBOOK_FILE_NAME = "AddressBook-file.txt";
	public static String ADDRESSBOOK_CSV_FILE_NAME = "AddressBook-CSV.csv";
	public static String ADDRESSBOOK_JSON_FILE_NAME = "AddressBook-JSON.json";
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

	public void writeDataToCsv(List<Contact> contacts){
		try {
			Writer writer = Files.newBufferedWriter(Paths.get(ADDRESSBOOK_CSV_FILE_NAME));
			CSVWriter csvWriter = new CSVWriter(writer,
					CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);
			List<String[]> contactList = new ArrayList();
			for(Contact c : contacts) {
				String[] row = {c.getFirstName(),c.getLastName(),c.getCity(),c.getState(),c.getZip(),c.getPhoneNumber(),c.getEmail()};
				contactList.add(row);
			}
			csvWriter.writeAll(contactList);
			csvWriter.close();

		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	public void readFromCsv() {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(ADDRESSBOOK_CSV_FILE_NAME));
			CSVReader csvReader = new CSVReader(reader);
			List<String[]> addressBookContact = csvReader.readAll();
			for (String[] contact : addressBookContact) {
				System.out.println("First Name: "+contact[0]);
				System.out.println("Last Name: "+contact[1]);
				System.out.println("City: "+contact[2]);
				System.out.println("State: "+contact[3]);
				System.out.println("Zip: "+contact[4]);
				System.out.println("Phone number: "+contact[5]);
				System.out.println("Email: "+contact[6]);
			}

		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void writeDatatoJSON(List<Contact> addressBook) {
		Gson gson = new Gson();
		String json = gson.toJson(addressBook);
		FileWriter writer;
		try {
			writer = new FileWriter(ADDRESSBOOK_JSON_FILE_NAME);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void readDataFromJSON() {
		Gson gson = new Gson();
		List<Contact> contactList = new ArrayList<Contact>();
		BufferedReader bufferObject;
		try {
			bufferObject = new BufferedReader(new FileReader(ADDRESSBOOK_JSON_FILE_NAME));
			Contact[] addressBookData = gson.fromJson(bufferObject, Contact[].class);
			contactList = Arrays.asList(addressBookData);
			for (Contact contact : contactList) {
				System.out.println("First Name: "+contact.getFirstName());
				System.out.println("Last Name: "+contact.getLastName());
				System.out.println("City: "+contact.getCity());
				System.out.println("State: "+contact.getState());
				System.out.println("Zip: "+contact.getZip());
				System.out.println("Phone number: "+contact.getPhoneNumber());
				System.out.println("Email: "+contact.getEmail());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}

}
