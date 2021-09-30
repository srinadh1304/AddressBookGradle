package com.bridgelabz.addressbookgradle;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
public class AddressBookCSVIO {
	public static String ADDRESSBOOK_CSV_FILE_NAME = "AddressBook-CSV.csv";

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
}
