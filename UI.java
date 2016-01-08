// Interface that must be implemented by all user interfaces


public interface UI {


    public void simpleMessage(String _message);


    public void errorMessage(String _message);


    public void onBegin();


    public void onTurnEnd();


    public Action promptForHouseholdAction(Household _hhld);


} //end interface
