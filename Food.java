// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType type_) {
	super(type_.getName(), 1);
	type = type_;
    } //end


} //end class