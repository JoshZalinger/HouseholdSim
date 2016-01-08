// Basic ASCI, in-terminal user interface

import java.util.Scanner;


public class TextInterface implements UI {

    private Scanner kb;


    public TextInterface() {
	kb = new Scanner(System.in);
    } //end


    public void simpleMessage(String message) {
	System.out.println(message);
    } //end


    public void errorMessage(String message) {
	System.err.println("ERROR: " + message);
    } //end errorMessage


    public void onBegin() {
	// Do nothing.
    } //end onBegin


    public void onTurnEnd() {
	/* ** */kb.nextLine();
    } //end


    public Action promptForHouseholdAction(Household _hhld) {
	while(true) {
	    System.out.print("> ");
	    String rawCommand = kb.nextLine().trim().toLowerCase();
	    Action action = Action.parse(rawCommand);
	    if (action != null) {
		// TODO: validate the command
		return action;
	    }
	    simpleMessage("Invalid command");
	}
    } //end


} //end class
