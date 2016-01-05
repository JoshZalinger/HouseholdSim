// Food type enum


public enum FoodType {

    CORN("Corn");


    private String name;


    FoodType(String _name) {
	name = _name;
    } //end


    public String getName() {
	return name;
    } //end


} //end enum