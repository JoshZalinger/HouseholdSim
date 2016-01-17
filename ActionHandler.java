// Class to house all the logic around applying actions.


public class ActionHandler {


    public static String validateAction(Household _hhld, Action _action, SimulationController _controller) {
	// Return an error string if action is invalid, or null if it is valid
	switch(_action.getActionType()) {

	    // =========== EAT ===============================
	case EAT:
	    Item item = _action.getItem();
	    if (item == null) {
		return "ActionHandler error for EAT action: no associated item.";
	    }
	    if (!(item instanceof Food)) {
		return "ActionHandler error for EAT action: item is not food.";
	    }
	    if (!(_hhld.hasItem(item))) {
		return "ActionHandler error for EAT action: no such item in hhld inventory.";
	    }
	    if (_hhld.getHunger() <= 0) {
		return "ActionHandler error for EAT action: hhld has 0 hunger.";
	    }
	    _hhld.eat((Food)item);
	    return null;

	    // =========== PUBLIC JOB ==========================
	case PUBLIC_JOB:
	    JobType jobType = _action.getJobType();
	    if (jobType == null) {
		return "ActionHandler error for " + _action.getActionType() + " action: no associated job type.";
	    }
	    // TODO: make sure household has skills required for job type
	    if (!_controller.hasPublicJobSlot(jobType)) {
		return "ActionHandler error for " + _action.getActionType() + " action: no open job slot for " + jobType;
	    }
	    return null;

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
