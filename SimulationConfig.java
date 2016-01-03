// Object containing all configutation info for a simulation.  Simulations should no get info from anywhere but this object.

import java.util.HashMap;

public class SimulationConfig {

    private static HashMap defaultValues;
    private HashMap values;

    static {
	defaultValues = new HashMap();
	defaultValues.put("population", 100);
    } //end static block


    public SimulationConfig(HashMap _commandArguments) {
	values = new HashMap();
	// TODO: search for a file from w/in the command args

	for(Object key: defaultValues.keySet()) {
	    String value;
	    // TODO: first, look for the key in the command args. Next, check the file (if there is one). Finally, use the default value
	    value = defaultValues.get(key).toString();

	    try {
		int intValue = Integer.parseInt(value);
		values.put(key, intValue);
	    }
	    catch(NumberFormatException e) {
		values.put(key, value);
	    }
	}

	// TODO: warn about unused arguments
    } //end


    public int getPopulation() {
	return ((Integer)values.get("population")).intValue();
    } //end


} //end
