package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * CSV reader utility
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class CsvReader {
	String delim = ",";
	String path;
	final static int WEATHER = 1;
	final static int FOOTBALL = 2;
	private Challenge challenge;
	
	/**
	 * Constructor for CsvReader.
	 * @param path Path to csv file
	 * @param delim Delimiter used in csv file
	 * @param  {@link Challenge.class} Implementation
	 * @param data String array containing the cells of the row
	 */
	public CsvReader(String path, String delim, Challenge challenge) {
		this.path = path;
		this.delim = delim;
		this.challenge = challenge;
	}
	
	/**
	 * Reads in the file located at @code{path} line by line.
	 * Applies row calculations specified in the challenge implementation.
	 * 
	 * @return String result of the challenge
	 */
	public String readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			// Header
			String row = reader.readLine();
			String[] data = row.split(delim);
			if (data.length<3) {
				reader.close();
				return "Error";
			}
			
			while ((row = reader.readLine()) != null) {
			    data = row.split(delim);
			    challenge.rowBasedCalculations(data);
			}
			reader.close();
			    
		} catch(FileNotFoundException a) {
			System.out.println("File not found.");
		} catch(IOException e) {
			System.out.println("Exception occurred while trying to read the file.");
			e.printStackTrace();
		}
		
		return challenge.getResult();
	}
}