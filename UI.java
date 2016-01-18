// Interface that must be implemented by all user interfaces

import java.util.ArrayList;


public interface UI {


    public void simpleMessage(String _message);


    public void errorMessage(String _message);


    public void onBegin();


    public void onTurnEnd(boolean _isStepTurn);


    // For human-controlled households.
    public void promptForHouseholdAction(Household _hhld, ArrayList<Action> actionList);


    // Potentially print some info about the hhld.
    public void onHouseholdBeginTurn(Household _hhld);


    public void onHouseholdChooseAction(Household _hhld, SimulationController _ui);


} //end interface
