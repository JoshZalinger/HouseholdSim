// Interface that must be implemented by all user interfaces

import java.util.ArrayList;


public interface UI {


    public void simpleMessage(String _message);


    public void errorMessage(String _message);


    public void onBegin();


    public void onTurnEnd();


    // For human-controlled households.
    public Action promptForHouseholdAction(Household _hhld, ArrayList<Action> actionList);


    // Potentially print some info about the hhld.
    public void onHouseholdBeginTurn(Household _hhld);


} //end interface
