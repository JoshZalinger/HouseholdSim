// AI that allows human user to control a household


public class HumanUserAI extends DefaultAI {


    public Action takeAction(SimulationController _controller) {
	Simulation.ui.simpleMessage("Hunger:\t" + household.getHunger());
	Simulation.ui.simpleMessage("Items:\t" + household.getInventoryUsed());

	 return Simulation.ui.promptForHouseholdAction(household);
    } //end


} //end class
