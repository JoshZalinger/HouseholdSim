// Structures


public class Structure {

    private StructureType type;
    private boolean underConstruction;
    // progress
    private int laborSoFar;


    public Structure(StructureType _type) {
	type = _type;
	underConstruction = true;
    } //end


    public StructureType getStructureType() {
	return type;
    } //end


    public boolean getUnderConstruction() {
	return underConstruction;
    } //end


    public void setUnderConstruction(boolean state) {
	underConstruction = state;
    } //end


    public String toString() {
	return type.toString();
    } //end


    public int getLaborSoFar() {
	return laborSoFar;
    } //end


    public void addLabor(int labor) {
	laborSoFar += labor;
    } //end


} //end class