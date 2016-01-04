// One action taken by a household, using one labor


public class Action {

    private ActionType actionType;


    public Action(ActionType _type) {
	actionType = _type;
    } //end


    public int getLaborCost() {
	return actionType.getLaborCost();
    } //end


} //end class
