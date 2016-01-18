// AI that allows human user to control a household

import java.util.ArrayList;


public class HumanUserAI extends DefaultAI {

    private ArrayList<Action> actionList;


    public HumanUserAI() {
	actionList = new ArrayList<Action>();
    } //end


    public Action takeAction(SimulationController _controller) {
	if (actionList.size() == 0) {
	    Simulation.ui.promptForHouseholdAction(household, actionList);
	}

	if (actionList.size() == 0) {
	    return null;
	}

	Action action = actionList.get(actionList.size()-1);
	actionList.remove(actionList.size()-1);
	return action;
    } //end


} //end class
