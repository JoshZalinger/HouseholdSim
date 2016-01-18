// Holds data above different levels, especially luxury requirements.

import java.util.ArrayList;


public class Level {

    public static Level[] levels;
    private int[] luxuryRequirements;
    private int turnsRequirement; // How many turns the hhld must stay at the next lux level before leveling up


    static {
	levels = new Level[2];

	levels[0] = new Level(0, new int[]{0});
	levels[1] = new Level(20, new int[]{0});
    } //end static block


    private Level(int _turns, int[] _luxury) {
	turnsRequirement = _turns;
	luxuryRequirements = _luxury;
    } //end


    public static boolean doesMeetLuxuryRequirement(Household _hhld, int levelNumber) {
	// Max level check:
	if(levelNumber >= levels.length) {
	    return false;
	}

	Level nextLevel = levels[levelNumber];
	int[] hhldLuxury = _hhld.getLuxuryAmounts();
	// Both luxury arrays should be sorted in descending order.
	for(int i = 0; i < nextLevel.luxuryRequirements.length; i++) {
	    if(hhldLuxury[i] < nextLevel.luxuryRequirements[i]) {
		return false;
	    }
	}
	return true;
    } //end


    public int getTurnsRequirement() {
	return turnsRequirement;
    } //end



} //end class
