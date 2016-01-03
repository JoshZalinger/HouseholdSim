// The main "controller" object that runs the simulation loop. This class is also equivalent to 'an instance of a simulation'.

import java.util.ArrayList;


public class SimulationController {

    private UI ui;
    private SimulationConfig config;
    private ArrayList<Household> households;


    public SimulationController(SimulationConfig _config, UI _ui) {
	config = _config;
	ui = _ui;
	households = new ArrayList<Household>();
    } //end


    public void begin() {
	init();
	ui.onBegin();
	while(true) {
	    doTurn();
	    ui.onTurnEnd();
	}
    } //end


    private void init() {
	//Create all the households:
	int pop = config.getPopulation();
	for(int i = 0; i < pop; i++) {
	    Household hhld = new Household();
	    households.add(hhld);
	}
    } //end


    private void doTurn() {
	ArrayList<Household> householdsCopy = new ArrayList<Household>();
	householdsCopy.addAll(households);
	while(householdsCopy.size() > 0) {
	    int r = (int)(Math.random() * householdsCopy.size());
	    Household hhld = householdsCopy.remove(r);
	    while(hhld.getRemainingLabor() > 0) {
		if(applyAction(hhld, hhld.getAI().takeAction())) {
		    break;
		}
		hhld.decrementRemainingLabor();
	    }
	    // TODO: apply mechanics (e.g. hunger) to the hhld
	    hhld.resetRemainingLabor();
	}
    } //end doTurn


    private boolean applyAction(Household _hhld, Action _action) {
	// Applies a household's action, return true if household's turn should end immediately.
	return false;
    } //end


} //end class
