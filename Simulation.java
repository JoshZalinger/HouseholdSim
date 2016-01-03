// Main class for the Household Simulation

import java.util.HashMap;
import ui.UI;
import ui.TextInterface;


public class Simulation {


    public static void main(String[] args) {
	UI ui = new TextInterface();
	ui.simpleMessage("Reading command line arguments...");
	HashMap arguments = buildArguments(args, ui);
	ui.simpleMessage("Building simulation configuration...");
	SimulationConfig config = new SimulationConfig(arguments);
	ui.simpleMessage("Starting simulation...");
	new SimulationController(config, ui).begin();
    } //end


    private static HashMap buildArguments(String[] args, UI ui) {
	// Turns command line arguments into a HashMap of key, value argument pairs
	if (args.length % 2 != 0) {
	    ui.errorMessage("Odd number of elements in arguments.");
	    ui.simpleMessage("Arguments should be of the form \"--key value\"");
	    System.exit(0);
	}
	for(int i = 0; i < args.length; i += 2) {
	    String key = args[i];
	    // TODO: make sure it is formatted correctly
	    // TODO: add it and the value to the hash map
	}

	return new HashMap();
    } //end


} //end class
