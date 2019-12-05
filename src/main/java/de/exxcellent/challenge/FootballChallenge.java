package de.exxcellent.challenge;

/**
 * The implementation class for the football data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class FootballChallenge implements Challenge{
	
	int deltaMin;
	String teamMinGoalDiff;
	
	public FootballChallenge() {
		// save best result
		deltaMin=Integer.MAX_VALUE;
		teamMinGoalDiff="A good team";
	}

	public void rowBasedCalculations(String[] data) {
		
		int goalsScored = parse(data[5]);
		int goalsAllowed = parse(data[6]);
		
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
	
	public int parse(String s) {
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
	
	public String getResult() {
		return teamMinGoalDiff;
	}

}
