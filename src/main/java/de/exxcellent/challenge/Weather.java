package de.exxcellent.challenge;

/**
 * The implementation class for the weather data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class Weather {
	// save best result
	static float deltaMin=Float.NaN;
	static String dayMin="Someday";

	public static void calculateTempSpread(String[] data) {
		
		float max = Weather.parseFloat(data[1]);
		float min = Weather.parseFloat(data[2]);
		
		// if first result
		if (!Float.isNaN(max) && !Float.isNaN(min)) {
			float delta = max-min;
			// or better result
			if (Float.isNaN(deltaMin) || delta < deltaMin) {
				// overwrite the best result
				deltaMin = delta;
				dayMin = data[0];
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
		return dayMin;
	}
}
