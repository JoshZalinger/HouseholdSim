// Main class for the Household Simulation

import java.util.HashMap;


public class Simulation {

    public static UI ui;


    public static void main(String[] args) {
	ui = new TextInterface();
	ui.simpleMessage("Reading command line arguments...");
	HashMap arguments = buildArguments(args);
	ui.simpleMessage("Building simulation configuration...");
	SimulationConfig config = new SimulationConfig(arguments);
	ui.simpleMessage("Starting simulation...");
	new SimulationController(config).begin();
    } //end


    private static HashMap buildArguments(String[] args) {
	// Turns command line arguments into a HashMap of key, value argument pairs
	if (args.length % 2 != 0) {
	    ui.errorMessage("Odd number of elements in arguments.");
	    ui.simpleMessage("Arguments should be of the form \"--key value\"");
	    System.exit(0);
	}
	HashMap map = new HashMap();
	for(int i = 0; i < args.length; i += 2) {
	    String key = args[i];
	    String value = args[i + 1];
	    // Make sure it is formatted correctly (i.e. starts with --):
	    if (key.indexOf("--") != 0) {
		ui.errorMessage("Argument key poorly formatted: \"" + key + "\"");
		System.exit(0);
	    }
	    key = key.substring(2);
	    map.put(key, value);
	}

	return map;
    } //end


} //end class
