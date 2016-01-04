// General methods for all items.


public abstract class Item {

    private String name;
    private int size; // amount of inventory space required per item


    public Item(String name_, int size_) {
	name = name_;
	size = size_;
    } //end


    public String getName() {
	return name;
    } //end


    public int getSize() {
	return size;
    } //end


} //end class