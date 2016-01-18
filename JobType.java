// All types of actual jobs (i.e. uses of labor) a household can perform.


public enum JobType {


    FORAGE(1);


    private int laborCost;


    private JobType(int _labor) {
	laborCost = _labor;
    } //end


    public static JobType parse(String _name) {
	for(JobType jb: values()) {
	    if(jb.toString().toLowerCase().equals(_name)) {
		return jb;
	    }
	}
	return null;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end getLaborCost


} //end class
