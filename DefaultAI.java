// Most basic AI possible, for testing.


public class DefaultAI extends AI {


    public Action takeAction(SimulationController _controller) {
	if (_controller.hasPublicJobSlot(JobType.FORAGE) && household.getRemainingLabor() > 0) {
	    return new Action(ActionType.PUBLIC_JOB, JobType.FORAGE);
	}
	else {
	    return new Action(ActionType.END_TURN);
	}
    } //end takeAction


} //end class
