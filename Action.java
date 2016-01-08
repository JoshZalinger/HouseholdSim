// One action taken by a household, using one labor


public class Action {

    private ActionType actionType;
    private Item item;


    public Action(ActionType _type) {
	actionType = _type;
    } //end


    public static Action parse(String _actionString) {
	ActionType parsedType = ActionType.parse(_actionString);
	if (parsedType != null) {
	    return new Action(parsedType);
	}
	return null;
    } //end


    public int getLaborCost() {
	return actionType.getLaborCost();
    } //end


    public ActionType getActionType() {
	return actionType;
    } //end getActionType


    public Item getItem() {
	return item;
    } //end


    public void setItem(Item _item) {
	item = _item;
    } //end


} //end class
