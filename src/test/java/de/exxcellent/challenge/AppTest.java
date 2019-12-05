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
    void runFootball() {
        App.main("--football", "football.csv");
    }
    @Test
    void runWeather() {
    	App.main("--weather", "weather.csv");
    	assertEquals(Weather.day_min, "14" , "");
    	assertEquals(Weather.delta_min, 2.0f , "");
    }
    @Test
    void runHelp() {
    	App.main("");
    }

}