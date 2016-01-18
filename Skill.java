// Enum representing skills a hhld can acquire at different levels.


public enum Skill {

    FARMER(1, "Farmer"),
    TOOLMAKER(1, "Toolmaker");


    private int level;
    private String name;


    private Skill(int _level, String _name) {
	level = _level;
	name = _name;
    } //end


    public String toString() {
	return name;
    } //end


    public int getLevel() {
	return level;
    } //end


    public static Skill parse(String _name) {
	for(Skill sk: values()) {
	    if(sk.toString().toLowerCase().equals(_name)) {
		return sk;
	    }
	}
	return null;
    } //end


} //end enum
