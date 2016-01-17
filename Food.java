// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType _type) {
	super(_type.toString(), 1);
	type = _type;
    } //end


    public static Food parse(String _foodString) {
	FoodType parsedType = FoodType.parse(_foodString);
	if (parsedType != null) {
	    return new Food(parsedType);
	}
	return null;
    } //end


    public FoodType getFoodType() {
	return type;
    } //end


    public boolean equals(Object o) {
	if (!(o instanceof Food)) {
	    return false;
	}
	return equals((Food)o);
    } //end


    public boolean equals(Food _food) {
	return (_food.getFoodType() == type);
    } //end


    public String toString() {
	return type.getName();
    } //end


} //end class
