package de.exxcellent.challenge;

/**
 * The interface for the implementing new challenges.
 *
 * @author Lukas Schmid <lhdschmid@gmail.com>
 */

interface Challenge {
	public void rowBasedCalculations(String[] data);
	public String getResult();
}
