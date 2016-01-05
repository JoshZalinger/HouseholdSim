// Food type items.


public class Food extends Item {

    private FoodType type;


    public Food(FoodType _type) {
	super(_type.getName(), 1);
	type = _type;
    } //end


} //end class