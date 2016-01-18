// Defines static values for specific structures


public enum StructureType {

    FARM("farm",50,Skill.FARMER);


    private String name;
    // requirements
    private Skill requiredSkill;
    private int laborCost;


    StructureType(String _name, int _laborCost, Skill _reqSkill) {
	name = _name;
	laborCost = _laborCost;
	requiredSkill = _reqSkill;
    } //end


    public static StructureType parse(String _name) {
	for (StructureType st: values()) {
	    if (st.toString().equals(_name)) {
		return st;
	    }
	}
	return null;
    } //end


    public String toString() {
	return name;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end


    public Skill getRequiredSkill() {
	return requiredSkill;
    } //end


} //end class