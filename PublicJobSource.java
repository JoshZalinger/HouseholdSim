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


} //end class
