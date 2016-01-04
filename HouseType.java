//


public enum HouseType {
    HOVEL (20);


    private int inventorySize;


    HouseType(int inventorySize_) {
	inventorySize = inventorySize_;
    } //end


    public int getInventorySize() {
	return inventorySize;
    } //end



} //end enum