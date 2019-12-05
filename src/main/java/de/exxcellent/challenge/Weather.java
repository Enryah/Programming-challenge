package de.exxcellent.challenge;

/**
 * The implementation class for the weather data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class Weather {
	// save best result
	static float delta_min=Float.NaN;
	static String day_min="Someday";

	public static void calculateTempSpread(String[] row) {
		
		float max = Weather.parseFloat(row[1]);
		float min = Weather.parseFloat(row[2]);
		
		// if first result
		if (max != Float.NaN && min != Float.NaN) {
			float delta = max-min;
			// or better result
			if (Float.isNaN(delta_min) || delta < delta_min) {
				// overwrite the best result
				delta_min = delta;
				day_min = row[0];
			}
		}
	}
	
	private static float parseFloat(String s) {
		// default value
		float f = Float.NaN;
		
		try {
			f = Float.parseFloat(s);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Error while parsing temperature data from String:" + s);
		}
		return f;
	}
	
	public static String getResult() {
		return day_min;
	}
}
