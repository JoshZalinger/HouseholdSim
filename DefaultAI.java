// Most basic AI possible, for testing.


public class DefaultAI extends AI {


    public Action takeAction(SimulationController _controller) {
	if (_controller.hasPublicJobSlot(JobType.FORAGE) && household.getRemainingLabor() > 0) {
	    return new Action(ActionType.PUBLIC_JOB, JobType.FORAGE);
	}

	// Hax; assumes corn is only food type.
	Item food = household.getFoodItem(FoodType.CORN);
	if(household.getHunger() > 0 && food != null) {
	    return new Action(ActionType.EAT, food);
	}

	return new Action(ActionType.END_TURN);
    } //end takeAction


} //end class
