// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType _type) {
	super(_type.getName(), 1);
	type = _type;
    } //end


    public FoodType getFoodType() {
	return type;
    } //end


    public String toString() {
	return type.getName();
    } //end


} //end class
