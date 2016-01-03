// Interface that must be implemented by all user interfaces

package ui;


public interface UI {


    public void simpleMessage(String message);


    public void errorMessage(String message);


    public void onBegin();


    public void onTurnEnd();


} //end interface
