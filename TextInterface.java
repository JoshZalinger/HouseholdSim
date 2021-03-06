// Basic ASCI, in-terminal user interface

import java.util.Scanner;
import java.util.ArrayList;


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


    public void onTurnEnd(boolean _isStepTurn) {
	if(_isStepTurn) {
	    kb.nextLine();
	}
    } //end


    public void promptForHouseholdAction(Household _hhld, ArrayList<Action> actionList) {
	while(true) {
	    System.out.print("> ");
	    String rawCommand = kb.nextLine().trim().toLowerCase();
	    Scanner input = new Scanner(rawCommand);
	    Action action;

	    if (!(input.hasNext())) {
		simpleMessage("No command");
		continue;
	    }

	    ActionType actionType = ActionType.parse(input.next());
	    if (actionType != null) {
		switch(actionType) {

		    // ================= EAT ==================
		case EAT:
		    if (!(input.hasNext())) {
			simpleMessage("No item specified to eat");
			continue;
		    }
		    Food food = Food.parse(input.next());
		    action = new Action(actionType, food);
		    break;

		    // ================= PUBLIC JOB ==================
		case PUBLIC_JOB:
		    if (!(input.hasNext())) {
			simpleMessage("No job type specified");
			continue;
		    }
		    JobType jobType = JobType.parse(input.next());
		    action = new Action(actionType, jobType);
		    break;

		    // ================= CRAFT TOOL ==================
		case CRAFT_TOOL:
		    if(!(input.hasNext())) {
			simpleMessage("No tool type specified.");
			continue;
		    }
		    ToolType toolType = ToolType.parse(input.next());
		    action = new Action(actionType, toolType);
		    break;

		    // ================= START STRUCTURE ==================
		case START_STRUCTURE:
		    if (!(input.hasNext())) {
			simpleMessage("No structure type specified");
			continue;
		    }
		    StructureType structureType = StructureType.parse(input.next());
		    action = new Action(actionType, structureType);
		    break;

		    // ================= BUILD STRUCTURE ==================
		case BUILD_STRUCTURE:
		    if (!(input.hasNext())) {
			simpleMessage("No structure type specified");
			continue;
		    }
		    StructureType buildStructType = StructureType.parse(input.next());
		    action = new Action(actionType, buildStructType);
		    break;

		default:
		    action = new Action(actionType);
		}

		if (input.hasNext()) {
		    int repeat = Integer.parseInt(input.next());
		    for (int i=0; i<repeat; i++) {
			actionList.add(action);
		    }
		} else {
		    actionList.add(action);
		}

		return;
	    } else {
		simpleMessage("Invalid command");
	    }
	}
    } //end


    public Skill promptForNewSkill(Household _hhld) {
	simpleMessage("Choose a skill.");
	while(true) {
	    System.out.print("> ");
	    String skillName = kb.nextLine().trim().toLowerCase();
	    Skill newSkill = Skill.parse(skillName);
	    if(newSkill != null) {
		return newSkill;
	    }
	}
    } //end


    public void onHouseholdBeginTurn(Household _hhld) {
	// Do nothing.
    } //end


    public void onHouseholdChooseAction(Household _hhld, SimulationController _controller) {
	if (_hhld.isHumanControlled()) {
	    printHouseholdStatus(_hhld);
	    System.out.println();
	}
	if (_hhld == _controller.getDayInLifeHousehold()) {
	    System.out.println();
	    printHouseholdStatus(_hhld);
	    kb.nextLine();
	}
    } //end


    public void printHouseholdStatus(Household _hhld) {
	System.out.println("Level:\t\t" + _hhld.getLevel());
	System.out.println("Hunger:\t\t" + _hhld.getHunger());
	System.out.println("Starvation:\t" + _hhld.getStarvation());
	System.out.println("Labor:\t\t" + _hhld.getRemainingLabor() + " / " + _hhld.getMaxLabor());
	System.out.println("Inventory:\t" + _hhld.getInventoryPrettyString());
	if(_hhld.getTurnsAtNextLuxuryLevel() > 0) {
	    System.out.println("Turns at next luxury level: " + _hhld.getTurnsAtNextLuxuryLevel());
	}
	ArrayList<Structure> structures = _hhld.getStructures();
	for (int i=0; i<structures.size(); i++) {
	    Structure struct = structures.get(i);
	    System.out.print("Structure (" + i + "):\t" + struct);
	    if (struct.getUnderConstruction()) {
		System.out.println("\t(under construction)");
		System.out.print("\tLabor: " + struct.getLaborSoFar() + "/" + struct.getStructureType().getLaborCost());
	    }
	    System.out.println();
	}
    } //end


} //end class
