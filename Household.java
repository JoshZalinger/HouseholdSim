// Actor within the simulation.
import java.util.*;


public class Household {

    private static final int BASE_LABOR = 8;
    private int remainingLabor; //this turn
    private AI ai;

    private int inventoryMax;
    private ArrayList<Item> inventoryItems;

    private int hunger;
    private HashMap<Vitamin, Integer> vitaminMap;
    private int[] vitaminStats;

    private House house;


    public Household() {
	super();
	ai = new DefaultAI(this);
	remainingLabor = calculateRemainingLabor();
	house = new House();
	inventoryMax = house.getInventorySize();
	inventoryItems = new ArrayList<Item>();
	vitaminStats = new int[3];

	//initialize hashmap for vitamin enum -> array index
	vitaminMap = new HashMap<Vitamin, Integer>();
	vitaminMap.put(Vitamin.VITAMIN_A, 0);
	vitaminMap.put(Vitamin.VITAMIN_B, 1);
	vitaminMap.put(Vitamin.VITAMIN_C, 2);
    } //end


    // returns true if item added to inventory successfully.
    public boolean addToInventory(Item item) {
	if (getInventoryFree() < 1) {
		return false;
	    }
	inventoryItems.add(item);
	return true;
    } //end


    // note: does not validate on its own
    public void eat(Food food) {
	int index;
	for (Vitamin vit : Vitamin.values()) {
	    index = vitaminMap.get(vit);
	    vitaminStats[index] += food.getFoodType().getVitaminStat(vit);
	}

	decrementHunger();
	removeItem(food);
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


    public Boolean hasItem(Item _item) {
	return inventoryItems.contains(_item);
    } //end


    public Boolean removeItem(Item _item) {
	return inventoryItems.remove(_item);
    } //end


    public int getHunger() {
	return hunger;
    } //end


    public void setHunger(int h) {
	hunger = h;
    } //end


    // decreases hunger by 1, to a minimum of 0
    public void decrementHunger() {
	if (hunger > 0) {
	    hunger--;
	}
    } //end


    public int getVitaminStat(Vitamin v) {
	return vitaminStats[vitaminMap.get(v)];
    } //end


    public void setVitaminStat(Vitamin v, int value) {
	vitaminStats[vitaminMap.get(v)] = value;
    } //end


} //end class
