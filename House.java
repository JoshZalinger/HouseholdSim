// House. 1 per Household.


public class House {

    private HouseType type;
    private int inventorySize;


    public House() {
	type = HouseType.HOVEL;
	inventorySize = type.getInventorySize();
    } //end


    public HouseType getType() {
	return type;
    } //end


    public int getInventorySize() {
	return inventorySize;
    } //end


} //end class