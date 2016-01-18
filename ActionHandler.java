// Class to house all the logic around applying actions.


public class ActionHandler {


    public static String validateAction(Household _hhld, Action _action, SimulationController _controller) {
	// Return an error string if action is invalid, or null if it is valid
	switch(_action.getActionType()) {

	    // =========== EAT ===============================
	case EAT:
	    Item item = _action.getItem();
	    if (item == null) {
		return "ActionHandler error for EAT action: no associated item.";
	    }
	    if (!(item instanceof Food)) {
		return "ActionHandler error for EAT action: item is not food.";
	    }
	    item = _hhld.getItem(item);
	    if (item == null) {
		return "ActionHandler error for EAT action: no such item in hhld inventory.";
	    }
	    if (_hhld.getHunger() <= 0) {
		return "ActionHandler error for EAT action: hhld has 0 hunger.";
	    }
	    return null;

	    // =========== PUBLIC JOB ==========================
	case PUBLIC_JOB:
	    JobType jobType = _action.getJobType();
	    if (jobType == null) {
		return "ActionHandler error for " + _action.getActionType() + " action: no associated job type.";
	    }
	    // TODO: make sure household has skills required for job type
	    if (!_controller.hasPublicJobSlot(jobType)) {
		return "ActionHandler error for " + _action.getActionType() + " action: no open job slot for " + jobType;
	    }
	    // TODO: make sure hhld's inventory is not full
	    return null;

	    // =============== CRAFT A TOOL =================
	case CRAFT_TOOL:
	    if(!_hhld.hasSkill(Skill.TOOLMAKER)) {
		return "ActionHandler error for CRAFT_TOOL: hhld does not have TOOLMAKER skill.";
	    }
	    if(!InventoryUtil.householdHasMaterials(_hhld, _action.getToolType().getMaterialCost())) {
		return "ActionHandler error for CRAFT_TOOL: hhld does not have material cost.";
	    }
	    return null;

	    // =========== START STRUCTURE ==========================
	case START_STRUCTURE:
	    StructureType structureType = _action.getStructureType();
	    if (structureType == null) {
		return "ActionHandler error for " + _action.getActionType() + " action: no associated structure type.";
	    }
	    if (!(_hhld.hasSkill(structureType.getRequiredSkill()))) {
		return "ActionHandler error for " + _action.getActionType() + " action: hhld doesn't have the required skill.";
	    }
	    if (_hhld.getStructure(structureType) != null) {
		return "ActionHandler error for " + _action.getActionType() + " action: hhld already has a structure of this type.";
	    }
	    return null;

	    // ================= BUILD STRUCTURE ==================
	case BUILD_STRUCTURE:
	    StructureType buildStructType = _action.getStructureType();
	    if (buildStructType == null) {
		return "ActionHandler error for " + _action.getActionType() + " action: no associated structure type.";
	    }
	    Structure structure = _hhld.getStructure(buildStructType);
	    if (structure == null) {
		return "ActionHandler error for " + _action.getActionType() + " action: hhld doesn't have a structure of that type.";
	    }
	    if (!(structure.getUnderConstruction())) {
		return "ActionHandler error for " + _action.getActionType() + " action: structure isn't currently under construction.";
	    }
	    return null;

	case END_TURN:
	    return null;

	default:
	    return "ActionHandler could not validate action type " + _action.getActionType();
	}
    } //end


    public static boolean applyAction(Household _hhld, Action _action, SimulationController _controller) {
	// Returns 'true' if turn should end after this action
	switch(_action.getActionType()) {

	    // ================= END TURN ==================
	case END_TURN:
	    return true;

	    // ================= EAT ==================
	case EAT:
	    Item item = _action.getItem();
	    item = _hhld.getItem(item);
	    _hhld.eat((Food)item);
	    return false;

	    // ================= PUBLIC JOB =================
	case PUBLIC_JOB:
	    JobType jobType = _action.getJobType();
	    _controller.claimPublicJobSlot(jobType);
	    return ActionHandler.applyJobType(_hhld, jobType, _controller);

	    // =============== CRAFT TOOL =================
	case CRAFT_TOOL:
	    InventoryUtil.subtractFromInventory(_hhld, _action.getToolType().getMaterialCost());
	    ToolItem tool  = new ToolItem(_action.getToolType());
	    _hhld.addToInventory(tool);
	    return false;

	    // ================= START STRUCTURE ==================
	case START_STRUCTURE:
	    StructureType structureType = _action.getStructureType();
	    _hhld.addStructure(new Structure(structureType));
	    return false;

	    // ================= BUILD STRUCTURE ==================
	case BUILD_STRUCTURE:
	    StructureType buildStructType = _action.getStructureType();
	    Structure structure = _hhld.getStructure(buildStructType);
	    structure.addLabor(1);
	    return false;

	default:
	    System.err.println("ERROR: ActionHandler could not apply action of type " + _action.getActionType());
	    return false;
	}
    } //end


    private static boolean applyJobType(Household _hhld, JobType _jobType, SimulationController _controller) {
	// Returns 'true' if turn should end after this action.
	switch(_jobType) {

	case FORAGE:
	    double forageChance = Math.random();
	    if (forageChance < _controller.getConfig().getForageChance()) {
		FoodType foodType = _controller.getConfig().getForageFoodType();
		_hhld.addToInventory(new Food(foodType));
	    }
	    return false;

	case GATHER_STICKS:
	    double gatherSticksChance = Math.random();
	    if (gatherSticksChance < _controller.getConfig().getGatherSticksChance()) {
		_hhld.addToInventory(new MaterialItem(MaterialItemType.STICK));
	    }
	    return false;

	default:
	    System.err.println("ERROR: ActionHandler could not apply job type " + _jobType);
	    return false;
	}
    } //end


} //end class
