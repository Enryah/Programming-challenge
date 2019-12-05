package de.exxcellent.challenge;

/**
 * The implementation class for the football data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class Football {
	
	// save best result
	static int deltaMin=Integer.MAX_VALUE;
	static String teamMinGoalDiff="A good team";

	public static void calculateGoalDiff(String[] data) {
		
		int goalsScored = Football.parseInt(data[5]);
		int goalsAllowed = Football.parseInt(data[6]);
		
		// if first result
		if (goalsScored != Integer.MAX_VALUE && goalsAllowed != Integer.MAX_VALUE) {
			int delta = Math.abs(goalsScored-goalsAllowed);
			// or better result
			if (delta < deltaMin) {
				// overwrite the best result
				deltaMin = delta;
				teamMinGoalDiff = data[0];
			}
		}
	}
	
	private static int parseInt(String s) {
		// default value
		int i = Integer.MAX_VALUE;
		
		try {
			i = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Error while parsing goal data from String:" + s);
		}
		return i;
	}
	
	public static String getResult() {
		return teamMinGoalDiff;
	}

}
