// General methods for all items.

import java.util.ArrayList;
import java.util.HashMap;


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


    public String toString() {
	return name;
    } //end


    public int getSize() {
	return size;
    } //end


    public static String getInventoryPrettyString(ArrayList<Item> items) {
	HashMap<String, Integer> histogram = new HashMap<String, Integer>();
	for(Item i: items) {
	    String itemName = i.toString();
	    Integer count = histogram.get(itemName);
	    if (count != null) {
		histogram.put(itemName, count.intValue() + 1);
	    }
	    else {
		histogram.put(itemName, 1);
	    }
	}
	String s = "";
	for(String key: histogram.keySet()) {
	    s += histogram.get(key).intValue() + " " + key + ",";
	}
	if(s.length() > 0) {
	    s = s.substring(0, s.length() - 1);
	}
	return s;
    } //end


} //end class
