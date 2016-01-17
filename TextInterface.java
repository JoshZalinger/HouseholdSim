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
	    Scanner input = new Scanner(rawCommand);

	    if (!(input.hasNext())) {
		simpleMessage("No command");
		continue;
	    }

	    Action action = Action.parse(input.next());
	    if (action != null) {
		// TODO: validate the command
		switch(action.getActionType()) {
		case EAT:
		    if (!(input.hasNext())) {
			simpleMessage("No item specified to eat");
			continue;
		    }
		    Food food = Food.parse(input.next());
		    action.setItem(food);
		default:
		}

		return action;
	    }
	    simpleMessage("Invalid command");
	}
    } //end


} //end class
