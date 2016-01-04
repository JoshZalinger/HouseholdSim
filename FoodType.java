// Food type enum


public enum FoodType {

    CORN("Corn");


    private String name;


    FoodType(String name_) {
	name = name_;
    } //end


    public String getName() {
	return name;
    } //end


} //end enum