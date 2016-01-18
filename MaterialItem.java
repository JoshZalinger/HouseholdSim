// Items that don't need durability.


public class MaterialItem extends Item {

    private MaterialItemType type;


    public MaterialItem(MaterialItemType _type) {
	super(_type.toString(), 1);
	type = _type;
    } //end


    public static MaterialItem parse(String _materialItemString) {
	MaterialItemType parsedType = MaterialItemType.parse(_materialItemString);
	if (parsedType != null) {
	    return new MaterialItem(parsedType);
	}
	return null;
    } //end


    public MaterialItemType getMaterialItemType() {
	return type;
    } //end


    public String toString() {
	return type.toString();
    } //end

} //end class