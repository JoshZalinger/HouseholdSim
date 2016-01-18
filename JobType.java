// All types of actual jobs (i.e. uses of labor) a household can perform.


public enum JobType {


    FORAGE(1, "forage"),
    GATHER_STICKS(1, "gathersticks");


    private int laborCost;
    private String name;


    private JobType(int _labor, String _name) {
	laborCost = _labor;
	name = _name;
    } //end


    public static JobType parse(String _name) {
	for(JobType jb: values()) {
	    if(jb.toString().equals(_name)) {
		return jb;
	    }
	}
	return null;
    } //end


    public String toString() {
	return name;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end getLaborCost


} //end class
