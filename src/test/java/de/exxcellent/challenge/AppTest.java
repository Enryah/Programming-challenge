package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @BeforeEach
    void setUp() {
    }

    @Test 
    void runBoth(){
    	System.out.println("Test runBoth:");
    	App.main("--football", "football.csv", "--weather", "weather.csv");
    	assertEquals("Aston_Villa", App.fbChallenge.teamMinGoalDiff, "");
    	assertEquals(1, App.fbChallenge.deltaMin, "");
    	assertEquals("14", App.wChallenge.getResult(), "");
    	assertEquals(2.0f, App.wChallenge.getDeltaMin(), "");
    	System.out.println();
    }

    @Test
    void runFootball() {
    	System.out.println("Test runFootball:");
        App.main("--football", "football.csv");
    	assertEquals("Aston_Villa", App.fbChallenge.teamMinGoalDiff, "");
    	assertEquals(1, App.fbChallenge.deltaMin, "");
    	System.out.println();
    }
    @Test
    void runWeather() {
    	System.out.println("Test runWeather:");
    	App.main("--weather", "weather.csv");
    	assertEquals("14", App.wChallenge.getResult(), "");
    	assertEquals(2.0f, App.wChallenge.getDeltaMin(), "");
    	System.out.println();
    }
    @Test
    void runHelp() {
    	System.out.println("Test runHelp()");
    	App.main("");
    	System.out.println();
    }

}