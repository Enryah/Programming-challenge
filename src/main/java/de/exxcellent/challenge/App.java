package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
    	
    	CsvReader weatherReader;
    	CsvReader footballReader;
    	String dayWithSmallestTempSpread = "Someday";
    	String teamWithSmallestGoalSpread = "A good team";
    	
    	
    	if (args.length == 0 || args.length == 1) {
    		App.printHelp();
    		return;
    	}
    	
    	if (args.length%2 != 0) {
    		System.out.println("Error: Missing argument(s)");
    		return;
    	}
    	
		for (int i = 0; i < args.length; i += 2) {
			switch (args[i]) {
			case "--football":
			case "-f":
				footballReader = new CsvReader("src/main/resources/de/exxcellent/challenge/" + args[i+1], ",", new FootballChallenge());
				teamWithSmallestGoalSpread = footballReader.readFile();
				break;
			case "--weather":
			case "-w":
				weatherReader = new CsvReader("src/main/resources/de/exxcellent/challenge/" + args[i+1], ",", new WeatherChallenge());
				dayWithSmallestTempSpread = weatherReader.readFile();
				break;
			default:
				printHelp();
				return;
			}
		}
		for (int i = 0; i < args.length; i++) {
			if (args[i]=="-w" || args[i]=="--weather") {
				System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
				
			}
			if (args[i]=="-f" || args[i]=="--football") {
				System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
			}
		}
    }
    
    public static void printHelp() {
    	System.out.println("Missing argument(s)");
    	System.out.println("Usage:" );
    	System.out.println("\t -w <csv-file>");
    	System.out.println("\t --weather <csv-file>");
    	System.out.println();
    	System.out.println("\t -f <csv-file>");
    	System.out.println("\t --football <csv-file>");
    }
}
