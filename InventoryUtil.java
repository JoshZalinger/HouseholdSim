// Home for utility functions related to items and inventories.

import java.util.HashMap;


public class InventoryUtil {


    public static boolean householdHasMaterials(Household _hhld, HashMap<MaterialItemType, Integer> _materials) {
	for(MaterialItemType materialType: _materials.keySet()) {
	    int hhldCount = countMaterialsInInventory(_hhld, materialType);
	    if(hhldCount < _materials.get(materialType).intValue()) {
		return false;
	    }
	}
	return true;
    } //end


    public static int countMaterialsInInventory(Household _hhld, MaterialItemType _materialType) {
	int count = 0;
	for(Item item: _hhld.getInventoryItems()) {
	    if(item instanceof MaterialItem) {
		if(((MaterialItem)item).getMaterialItemType() == _materialType) {
		    count++;
		}
	    }
	}
	return count;
    } //end


    public static void subtractFromInventory(Household _hhld, HashMap<MaterialItemType, Integer> _materials) {
	for(MaterialItemType materialType: _materials.keySet()) {
	    for(int i = 0; i < _materials.get(materialType).intValue(); i++) {
		Item toRemove = getItemFromInventory(_hhld, materialType);
		_hhld.removeItem(toRemove);
	    }
	}
    } //end


    public static Item getItemFromInventory(Household _hhld, MaterialItemType _materialType) {
	for(Item item: _hhld.getInventoryItems()) {
	    if(item instanceof MaterialItem && ((MaterialItem)item).getMaterialItemType() == _materialType) {
		return item;
	    }
	}
	return null;
    } //end


} //end class
