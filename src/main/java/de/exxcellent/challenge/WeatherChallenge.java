package de.exxcellent.challenge;

/**
 * The implementation class for the weather data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class WeatherChallenge implements Challenge{
	// save best result
	float deltaMin;
	String dayMin;
	
	public WeatherChallenge() {
		deltaMin=Float.NaN;
		dayMin="Someday";
	}

	public void rowBasedCalculations(String[] data) {
		
		float max = parse(data[1]);
		float min = parse(data[2]);
		
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
	
	private float parse(String s) {
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
	
	public String getResult() {
		return dayMin;
	}
}
