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
	
	public CsvReader(String path, String delim, Challenge challenge) {
		this.path = path;
		this.delim = delim;
		this.challenge = challenge;
	}
	
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