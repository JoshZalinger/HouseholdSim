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

	Action action = actionList.get(actionList.size());
	actionList.remove(actionList.size());
	return action;
    } //end


} //end class
