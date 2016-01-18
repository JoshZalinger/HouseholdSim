// One action taken by a household, using one labor


public class Action {

    private ActionType actionType;
    private Item item;
    private JobType jobType;


    public Action(ActionType _type) {
	actionType = _type;
    } //end

    public Action(ActionType _type, Item _item) {
	this(_type);
	item = _item;
    } //end

    public Action(ActionType _type, JobType _jobType) {
	this(_type);
	jobType = _jobType;
    } //end


    public static Action parse(String _actionString) {
	ActionType parsedType = ActionType.parse(_actionString);
	if (parsedType != null) {
	    return new Action(parsedType);
	}
	return null;
    } //end

    public int getLaborCost() {
	if(jobType != null) {
	    return jobType.getLaborCost();
	}
	return actionType.getLaborCost();
    } //end




    // =================== ACCESSORS =====================

    public ActionType getActionType() {
	return actionType;
    } //end getActionType

    public Item getItem() {
	return item;
    } //end

    public JobType getJobType() {
	return jobType;
    } //end getJobType


} //end class
