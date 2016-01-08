// Defines different categories of actions a household can take.


public enum ActionType {

    END_TURN(0, "end turn"),
    EAT(0, "eat");



    private int laborCost;
    private String name;


    private ActionType(int _labor, String _name) {
	laborCost = _labor;
	name = _name;
    } //end


    public static ActionType parse(String _name) {
	for(ActionType at: values()) {
	    if(at.toString().equals(_name)) {
		return at;
	    }
	}
	return null;
    } //end


    public String toString() {
	return name;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end


} //end enum
