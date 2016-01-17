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
	// Do nothing.
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


    public void onHouseholdBeginTurn(Household _hhld) {
	if (_hhld.isHumanControlled()) {
	    printHouseholdStatus(_hhld);
	    System.out.println();
	}
    } //end


    public void printHouseholdStatus(Household _hhld) {
	System.out.println("Hunger:\t\t" + _hhld.getHunger());
	System.out.println("Starvation:\t" + _hhld.getStarvation());
	System.out.println("Labor:\t\t" + _hhld.getRemainingLabor() + " / " + _hhld.getMaxLabor());
	System.out.println("Inventory:\t" + _hhld.getInventoryPrettyString());
    } //end


} //end class
