// The main "controller" object that runs the simulation loop. This class is also equivalent to 'an instance of a simulation'.

import java.util.ArrayList;
import java.util.HashMap;


public class SimulationController {

    private SimulationConfig config;
    private ArrayList<Household> households;
    private int turnNumber;
    private HashMap<JobType, PublicJobSource> publicJobs;


    public SimulationController(SimulationConfig _config) {
	config = _config;
    } //end


    public void begin() {
	init();
	Simulation.ui.onBegin();
	while(true) {
	    doTurn();
	    Simulation.ui.onTurnEnd();
	}
    } //end


    private void init() {
	//Create all the households:
	int pop = config.getPopulation();
	households = new ArrayList<Household>();
	for(int i = 0; i < pop; i++) {
	    AI ai;
	    if (i == 0 && config.isHumanUser()) {
		ai = new HumanUserAI();
	    }
	    else {
		ai = new DefaultAI();
	    }
	    Household hhld = new Household(ai);
	    households.add(hhld);
	}

	turnNumber = 0;

	publicJobs = new HashMap<JobType, PublicJobSource>();
	publicJobs.put(JobType.FORAGE, new PublicJobSource(JobType.FORAGE, config.getForageJobSlots()));
    } //end


    private void doTurn() {
	ArrayList<Household> householdsCopy = new ArrayList<Household>();
	householdsCopy.addAll(households);
	Simulation.ui.simpleMessage("Turn " + turnNumber);
	while(householdsCopy.size() > 0) {
	    int r = (int)(Math.random() * householdsCopy.size());
	    Household hhld = householdsCopy.remove(r);
	    while(true) {
		Action action = hhld.getAI().takeAction(this);
		if (action.getLaborCost() > hhld.getRemainingLabor()) {
		    System.err.println("ERROR: household attempted to use above max labor in a turn.");
		}
		else if(applyAction(hhld, action)) {
		    break;
		}
	    }
	    // TODO: apply mechanics (e.g. hunger) to the hhld
	    hhld.resetRemainingLabor();
	    hhld.updateStarvation();
	}
	turnNumber++;
    } //end doTurn


    private boolean applyAction(Household _hhld, Action _action) {
	// Applies a household's action, return true if household's turn should end immediately.
	String error = ActionHandler.validateAction(_hhld, _action, this);
	if(error != null) {
	    Simulation.ui.errorMessage(error);
	    return false;
	}
	boolean endTurn = ActionHandler.applyAction(_hhld, _action, this);
	_hhld.decrementRemainingLabor(_action.getLaborCost());
	return endTurn;
    } //end


    public boolean hasPublicJobSlot(JobType _jobType) {
	PublicJobSource jobSource = publicJobs.get(_jobType);
	return jobSource != null && jobSource.getCurrentOpenSlots() > 0;
    } //end


} //end class
