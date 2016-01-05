// Defines different categories of actions a household can take.


public enum ActionType {

    END_TURN(0),
    EAT(0);



    private int laborCost;


    private ActionType(int _labor) {
	laborCost = _labor;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end


} //end enum
