package de.exxcellent.challenge;

import java.io.BufferedReader;
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
	
	public CsvReader(String path, String delim) {
		this.path = path;
		this.delim = delim;
	}
	
	public String readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			// Header
			String row = reader.readLine();
			
			while ((row = reader.readLine()) != null) {
			    String[] data = row.split(delim);
			    Weather.calculateTempSpread(data);	
			    }
			reader.close();
			    
		} catch(IOException e) {
			System.out.println("Exception occurred while trying to read the file.");
			e.printStackTrace();
		}
		return Weather.getResult();
	}

}
