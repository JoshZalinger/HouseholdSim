// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType _type) {
	super(_type.getName(), 1);
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


} //end class