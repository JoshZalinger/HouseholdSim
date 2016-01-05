// Class to house all the logic around applying actions.


public class ActionHandler {


    public static String validateAction(Household _hhld, Action _action, SimulationController _controller) {
	// Return an error string if action is invalid, or null if it is valid
	switch(_action.getActionType()) {

	case END_TURN:
	    return null;

	default:
	    return "ActionHandler could not validate action type " + _action.getActionType();
	}
    } //end


    public static boolean applyAction(Household _hhld, Action _action, SimulationController _controller) {
	// Returns 'true' if turn should end after this action
	switch(_action.getActionType()) {

	case END_TURN:
	    return true;

	default:
	    System.err.println("ERROR: ActionHandler could not apply action of type " + _action.getActionType());
	    return false;
	}
    } //end


} //end class
