package Value;

/**
 *
 * @author ACER E1 471
 */
public class Value {
    private static Value instance;
    
    private Value() {
        
    }
    
    public static synchronized Value getInstance() {
        if (instance == null) {
            instance = new Value();
        }
        return instance;
    }
    
    
    private static int groundGrass = 0;
    private static int groundRoad = 1;
    
    private static int airAir = -1;
    private static int airCave = 0;
    private static int creepAir = -1;
    
    public int getgroundGrass() {
        return groundGrass;
    }
    
    public int getgroundRoad() {
        return groundRoad;
    }
    
    public int getairAir() {
        return airAir;
    }
    
    public int getairCave() {
        return airCave;
    }
}
