// Object containing all configutation info for a simulation.  Simulations should no get info from anywhere but this object.

import java.util.HashMap;

public class SimulationConfig {

    private static HashMap defaultValues;
    private HashMap values;

    static {
	defaultValues = new HashMap();
	defaultValues.put("population", 100);
	defaultValues.put("humanuser", false);
	defaultValues.put("foragejobslots", 800);
	defaultValues.put("foragechance", 0.5);
	defaultValues.put("foragefoodtype", "corn");
	defaultValues.put("dayinlife", false);
    } //end static block


    public SimulationConfig(HashMap _commandArguments) {
	values = new HashMap();
	// TODO: search for a file from w/in the command args

	for(Object key: defaultValues.keySet()) {
	    String value;
	    // First, look for the key in the command args.
	    Object commandArg = _commandArguments.get(key);
	    if (commandArg != null) {
		value = commandArg.toString();
	    }
	    // TODO: look for key in file (if applicable)
	    else {
		// Did not find key elsewhere, use default.
		value = defaultValues.get(key).toString();
	    }

	    try {
		int intValue = Integer.parseInt(value);
		values.put(key, intValue);
	    }
	    catch(NumberFormatException e) {
		try {
		    double d = Double.parseDouble(value);
		    values.put(key, d);
		}
		catch(NumberFormatException e2) {
		    if (Boolean.parseBoolean(value) || value.toLowerCase().trim().equals("false")) {
			values.put(key, Boolean.valueOf(value));
		    }
		    else {
			values.put(key, value);
		    }
		}
	    }
	}

	// TODO: warn about unused arguments
    } //end


    public int getPopulation() {
	return ((Integer)values.get("population")).intValue();
    } //end


    public boolean isHumanUser() {
	return ((Boolean)values.get("humanuser")).booleanValue();
    } //end


    public int getForageJobSlots() {
	return ((Integer)values.get("foragejobslots")).intValue();
    } //end


    public double getForageChance() {
	return ((Double)values.get("foragechance")).doubleValue();
    } //end


    public FoodType getForageFoodType() {
	return FoodType.parse(values.get("foragefoodtype").toString());
    } //end

    public boolean isDayInLife() {
	return ((Boolean)values.get("dayinlife")).booleanValue();
    } //end


} //end
