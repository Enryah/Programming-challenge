package de.exxcellent.challenge;

/**
 * The implementation class for the football data challenge.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

public class FootballChallenge implements Challenge{
	// for saving result
	int deltaMin;
	String teamMinGoalDiff;
	
	public FootballChallenge() {
		// default values
		deltaMin=Integer.MAX_VALUE;
		teamMinGoalDiff="A good team";
	}

	/**
	 * This function calculates the goal difference for a team.
	 * Difference and team name are saved to @code{deltaMin} and @code{teamMinGoalDiff} respectively.
	 * @code{data[5]} must contain goals scored,
	 * @code{data[6]} must contain goals allowed
	 *
	 * @param data String array containing the cells of the row
	 */
	public void rowBasedCalculations(String[] data) {
		
		int goalsScored = parse(data[5]);
		int goalsAllowed = parse(data[6]);
		
		// if parsing went okay
		if (goalsScored != Integer.MAX_VALUE && goalsAllowed != Integer.MAX_VALUE) {
			int delta = Math.abs(goalsScored-goalsAllowed);
			// if better result
			if (delta < deltaMin) {
				// overwrite the best result
				deltaMin = delta;
				teamMinGoalDiff = data[0];
			}
		}
	}
	
	/**
	 * This function handles parsing to int values.
	 *
	 * @param s String containing data from a cell
	 * 
	 * @return parsed int value of @code{s}
	 */
	public int parse(String s) {
		// default value
		int i = Integer.MAX_VALUE;
		
		try {
			i = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Error while parsing goal data from String:" + s);
			System.out.println("Skipping row");
		}
		return i;
	}
	
	/**
	 * Returns the team with the smallest goal difference.
	 * 
	 * @return String @code{teamMinGoalDiff}
	 */
	public String getResult() {
		return teamMinGoalDiff;
	}
	
	/**
	 * Returns the smallest goal difference.
	 * 
	 * @return int @code{deltaMin}
	 */
	public int getGoalDiff() {
		return deltaMin;
	}
	
	

}
