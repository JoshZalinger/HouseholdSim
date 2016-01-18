// Describes different types (levels) of tools.

import java.util.HashMap;


public enum ToolType {

    STICK_TOOL("StickTool");


    static {
	STICK_TOOL.laborCost = 6;
	STICK_TOOL.materialCost.put(MaterialItemType.STICK, 3);
    }


    private String name;
    private int laborCost;
    private HashMap<MaterialItemType, Integer> materialCost;


    private ToolType(String _name) {
	name = _name;
	materialCost = new HashMap<MaterialItemType, Integer>();
    } //end


    public String toString() {
	return name;
    } //end


    public HashMap<MaterialItemType, Integer> getMaterialCost() {
	return materialCost;
    } //end


    public int getLaborCost() {
	return laborCost;
    } //end


    public static ToolType parse(String _name) {
	for(ToolType tt: values()) {
	    if(tt.toString().toLowerCase().equals(_name.toLowerCase())) {
		return tt;
	    }
	}
	return null;
    } //end


} //end enum
