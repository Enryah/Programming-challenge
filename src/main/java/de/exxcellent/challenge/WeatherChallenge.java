package de.exxcellent.challenge;

/**
 * The implementation class for the weather data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class WeatherChallenge implements Challenge{
	// for saving result
	private float deltaMin;
	private String dayMin;
	
	public WeatherChallenge() {
		// default values
		deltaMin=Float.NaN;
		dayMin="Someday";
	}

	/**
	 * This function calculates the temperature spread in a day.
	 * Spread and day number are saved to @code{deltaMin} and @code{dayMin} respectively.
	 * @code{data[1]} must contain maximum temperature,
	 * @code{data[2]} must contain minimum temperature
	 *
	 * @param data String array containing the cells of the row
	 */
	public void rowBasedCalculations(String[] data) {
		
		float max = parse(data[1]);
		float min = parse(data[2]);
		
		// if parsing went okay
		if (!Float.isNaN(max) && !Float.isNaN(min)) {
			// for safety, if switched up, take absolute value
			float delta = Math.abs(max-min);
			// if better result
			if (Float.isNaN(deltaMin) || delta < deltaMin) {
				// overwrite the best result
				deltaMin = delta;
				dayMin = data[0];
			}
		}
	}
	
	/**
	 * This function handles parsing to float values.
	 *
	 * @param s String array containing data from a cell
	 * 
	 * @return parsed float value of @code{s}
	 */
	private float parse(String s) {
		// default value
		float f = Float.NaN;
		
		try {
			f = Float.parseFloat(s);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Error while parsing temperature data from String:" + s);
			System.out.println("Skipping row");
		}
		return f;
	}
	
	/**
	 * Returns the day with the smallest temperature spread.
	 * 
	 * @return String @code{dayMin}
	 */
	public String getResult() {
		return dayMin;
	}
	
	/**
	 * Returns the smallest temperature spread.
	 * 
	 * @return float @code{deltaMin}
	 */
	public float getDeltaMin() {
		return deltaMin;
	}
}
