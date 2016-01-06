// Food type enum
import java.util.*;


public enum FoodType {

    CORN("Corn", 0, 0, 0);


    private String name;
    private HashMap<Vitamin, Integer> vitaminMap;
    private int[] vitaminStats;


    FoodType(String _name, int _vitA, int _vitB, int _vitC) {
	name = _name;

	//initialize hashmap for viatmin enum -> array index
	vitaminMap = new HashMap<Vitamin, Integer>();
	vitaminMap.put(Vitamin.VITAMIN_A, 0);
	vitaminMap.put(Vitamin.VITAMIN_B, 1);
	vitaminMap.put(Vitamin.VITAMIN_C, 2);

	//set vitamin values
	vitaminStats = new int[3];
	vitaminStats[0] = _vitA;
	vitaminStats[1] = _vitB;
	vitaminStats[2] = _vitC;
    } //end


    public String getName() {
	return name;
    } //end


    public int getVitaminStat(Vitamin vit) {
	return vitaminStats[vitaminMap.get(vit)];
    } //end


} //end enum