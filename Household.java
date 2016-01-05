// Actor within the simulation.
import java.util.*;


public class Household {

    private static final int BASE_LABOR = 8;
    private int remainingLabor; //this turn
    private AI ai;

    private int inventoryMax;
    private ArrayList<Item> inventoryItems;

    private int hunger;

    private House house;


    public Household() {
	super();
	ai = new DefaultAI(this);
	remainingLabor = calculateRemainingLabor();
	house = new House();
	inventoryMax = house.getInventorySize();
	inventoryItems = new ArrayList<Item>();
    } //end


    // returns true if item added to inventory successfully.
    public bool addToInventory(Item item) {
	if (getInventoryFree() < 1) {
		return false;
	    }
	inventoryItems.add(item);
	return true;
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


    public int getInventoryMax() {
	return inventoryMax;
    } //end


    public int getInventoryUsed() {
	return inventoryItems.size();
    } //end


    public int getInventoryFree() {
	return inventoryMax - inventoryItems.size();
    } //end


    public ArrayList<Item> getInventoryItems() {
	return inventoryItems;
    } //end


    public int getHunger() {
	return hunger;
    } //end


    public void setHunger(int h) {
	hunger = h;
    } //end


} //end class
