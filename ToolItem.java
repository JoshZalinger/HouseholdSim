// Item subclass specifically for tools.


public class ToolItem extends Item {

    private ToolType toolType;


    public ToolItem(ToolType _toolType) {
	super(_toolType.toString(), 1);
	toolType = _toolType;
    } //end


    public ToolType getToolType() {
	return toolType;
    } //end


} //end class
