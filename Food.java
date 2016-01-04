// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType type_) {
	type = type_;
	super(type.getName(), 1);
    } //end


} //end class