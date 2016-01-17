// AI that allows human user to control a household


public class HumanUserAI extends DefaultAI {


    public Action takeAction(SimulationController _controller) {
	 return Simulation.ui.promptForHouseholdAction(household);
    } //end


} //end class
