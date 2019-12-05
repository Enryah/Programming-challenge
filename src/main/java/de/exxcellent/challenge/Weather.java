package de.exxcellent.challenge;

/**
 * The implementation class for the weather data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class Weather {
	// default result
	static float delta_min=Float.NaN;
	static String day_min="Someday";

	public static void calculateTempSpread(String[] row) {

		float a = Weather.parseFloat(row[1]);
		float b = Weather.parseFloat(row[2]);
		
		// if first result
		if (a != Float.NaN && b != Float.NaN) {
			float delta = b-a;
			// or better result
			if (delta_min == Float.NaN || delta_min > delta) {
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
