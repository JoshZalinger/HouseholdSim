// A global, persistent source of public jobs.  It has slots that can be filled by households each turn.


public class PublicJobSource {

    private JobType jobType;
    private int maxSlots;
    private int currentOpenSlots;


    public PublicJobSource(JobType _jobType, int _slots) {
	jobType = _jobType;
	maxSlots = _slots;
	currentOpenSlots = maxSlots;
    } //end


    public int getCurrentOpenSlots() {
	return currentOpenSlots;
    } //end


    public void claimSlot() {
	if (currentOpenSlots == 0) {
	    System.err.println("ERROR: tried to claim public job slot when none were open (" + jobType + ")");
	    return;
	}
	currentOpenSlots--;
    } //end claimSlot


    public void onEndTurn() {
	currentOpenSlots = maxSlots;
    } //end


} //end class
