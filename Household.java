// Actor within the simulation.
import java.util.*;


public class Household {

    private static final int BASE_LABOR = 8;
    private int remainingLabor; //this turn
    private AI ai;

    private int inventoryMax;
    private ArrayList<Item> inventoryItems;

    private int hunger; // hunger counts down as food is eaten
    private int starvation; // starvation counts up as meals are missed
    private HashMap<Vitamin, Integer> vitaminMap;
    private int[] vitaminStats;

    private House house;

    private int level;
    private int turnsAtNextLuxuryLevel;
    private ArrayList<Skill> skills;


    public Household(AI _ai) {
	super();
	ai = _ai;
	ai.setOwner(this);
	remainingLabor = getMaxLabor();
	house = new House();
	inventoryMax = house.getInventorySize();
	inventoryItems = new ArrayList<Item>();
	vitaminStats = new int[3];
	skills = new ArrayList<Skill>();

	level = 0;

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


    public int getMaxLabor() {
	// TODO: consider housing, etc
	return BASE_LABOR;
    } //end


    public void decrementRemainingLabor(int n) {
	remainingLabor -= n;
	if(remainingLabor < 0) {
	    System.err.println("ERROR: hhld's remaining labor is below 0");
	}
    } //end


    public void resetRemainingLabor() {
	remainingLabor = getMaxLabor();
    } //end


    public void updateStarvation() {
	if (hunger > 0) {
	    starvation += hunger;
	}
	else if (starvation > 0) {
	    starvation--;
	}
    } //end


    public void onEndTurn(SimulationController _controller) {
	resetRemainingLabor();
	updateStarvation();
	updateLuxury(_controller);
    } //end


    private void updateLuxury(SimulationController _controller) {
	// TODO: if below own luxury level, put in probation

	if(starvation > 0) {
	    // If hhld is staving, they automatically lose all luxury progress.
	    turnsAtNextLuxuryLevel = 0;
	}
	else if(Level.doesMeetLuxuryRequirement(this, level + 1)) {
	    turnsAtNextLuxuryLevel++;
	    if(turnsAtNextLuxuryLevel >= Level.levels[level + 1].getTurnsRequirement()) {
		levelUp(_controller);
	    }
	}
	else {
	    turnsAtNextLuxuryLevel = 0;
	}
    } //end


    public int[] getLuxuryAmounts() {
	// Return array of luxury amounts (category-agnostic), sorted in descending order.

	// hax
	return new int[]{0};
    } //end


    private void levelUp(SimulationController _controller) {
	level++;
	Skill newSkill = ai.chooseSkill(_controller);
	if(newSkill.getLevel() != level) {
	    System.err.println("ERROR: hhld chose skill at inappropriate level");
	}
	else {
	    skills.add(newSkill);
	}

	turnsAtNextLuxuryLevel = 0;
    } //end


    /////////////////////////////
    //   Getters and Setters   //
    /////////////////////////////
    public int getRemainingLabor() {
	return remainingLabor;
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


    public Item getItem(Item _item) {
	for (int i=0; i<inventoryItems.size(); i++) {
	    if (inventoryItems.get(i).equals(_item)) {
		return inventoryItems.get(i);
	    }
	}
	return null;
    } //end


    public Boolean removeItem(Item _item) {
	if (_item == null) {
	    return false;
	}

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


    public int getStarvation() {
	return starvation;
    } //end


    public void setStarvation(int _starvation) {
	starvation = _starvation;
    } //end


    public String getInventoryPrettyString() {
	return Item.getInventoryPrettyString(inventoryItems);
    } //end


    public boolean isHumanControlled() {
	return ai instanceof HumanUserAI;
    } //end


    public Food getFoodItem(FoodType _type) {
	for(Item i: inventoryItems) {
	    if(i instanceof Food) {
		Food f = (Food)i;
		if(f.getFoodType() == _type) {
		    return f;
		}
	    }
	}
	return null;
    } //end


    public int getLevel() {
	return level;
    } //end


    public int getTurnsAtNextLuxuryLevel() {
	return turnsAtNextLuxuryLevel;
    } //end


    public void setAI(AI _ai) {
	ai = _ai;
    } //end


    public boolean hasSkill(Skill _skill) {
	for(Skill s: skills) {
	    if(s == _skill) {
		return true;
	    }
	}
	return false;
    } //end


} //end class
