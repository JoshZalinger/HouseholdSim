// Actor within the simulation.


public class Household {

    private static final int BASE_LABOR = 8;
    private int remainingLabor; //this turn
    private AI ai;

    private int inventoryMax;

    private House house;


    public Household() {
	super();
	ai = new DefaultAI(this);
	remainingLabor = calculateRemainingLabor();
	house = new House();
	inventoryMax = house.getInventorySize();
    } //end


    private int calculateRemainingLabor() {
	// TODO: consider housing, etc
	return BASE_LABOR;
    } //end


    public int getRemainingLabor() {
	return remainingLabor;
    } //end


    public void decrementRemainingLabor(int n) {
	remainingLabor -= n;
	if(remainingLabor < 0) {
	    System.err.println("ERROR: hhld's remaining labor is below 0");
	}
    } //end


    public void resetRemainingLabor() {
	remainingLabor = calculateRemainingLabor();
    } //end


    public AI getAI() {
	return ai;
    } //end


} //end class
