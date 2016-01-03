// Most basic AI possible, for testing.


public class DefaultAI extends AI {


    public DefaultAI(Household _hhld) {
	super(_hhld);
    } //end


    public Action takeAction() {
	return new Action();
    } //end takeAction


} //end class
