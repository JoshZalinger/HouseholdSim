// Material item type enum


public enum MaterialItemType {

    STICK("stick");


    private String name;


    MaterialItemType(String _name) {
	name = _name;
    } //end


    public static MaterialItemType parse(String _name) {
	for (MaterialItemType ma: values()) {
	    if (ma.toString().equals(_name)) {
		return ma;
	    }
	}
	return null;
    } //end


    public String toString() {
	return name;
    } //end


} //end enum