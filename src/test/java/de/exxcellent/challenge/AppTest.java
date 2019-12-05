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
    	App.main("--football", "football.csv", "--weather", "weather.csv");
    	assertEquals("Aston_Villa", Football.teamMinGoalDiff, "");
    	assertEquals(1, Football.deltaMin, "");
    	assertEquals("14", Weather.dayMin, "");
    	assertEquals(2.0f, Weather.deltaMin, "");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    	assertEquals("Aston_Villa", Football.teamMinGoalDiff, "");
    	assertEquals(1, Football.deltaMin, "");
    }
    @Test
    void runWeather() {
    	App.main("--weather", "weather.csv");
    	assertEquals("14", Weather.dayMin, "");
    	assertEquals(2.0f, Weather.deltaMin, "");
    }
    @Test
    void runHelp() {
    	App.main("");
    }

}