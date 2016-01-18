// Interface that must be implemented by all user interfaces


public interface UI {


    public void simpleMessage(String _message);


    public void errorMessage(String _message);


    public void onBegin();


    public void onTurnEnd();


    // For human-controlled households.
    public Action promptForHouseholdAction(Household _hhld);


    // Potentially print some info about the hhld.
    public void onHouseholdBeginTurn(Household _hhld);


    public void onHouseholdChooseAction(Household _hhld, SimulationController _ui);


} //end interface
