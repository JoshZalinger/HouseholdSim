// The main "controller" object that runs the simulation loop. This class is also equivalent to 'an instance of a simulation'.

import java.util.ArrayList;
import ui.UI;


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
	    // TODO: simulate a turn
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


} //end class
