// Most basic AI possible, for testing.


public class DefaultAI extends AI {


    public Action takeAction() {
	return new Action(ActionType.END_TURN);
    } //end takeAction


} //end class
