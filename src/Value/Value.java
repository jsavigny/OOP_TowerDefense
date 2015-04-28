package Value;

/**
 *
 * @author ACER E1 471
 */
public class Value {
    private static int groundGrass = 0;
    private static int groundRoad = 1;
    
    private static int airAir = -1;
    private static int airCave = 0;
    private static int creepAir = -1;
    
    public static int getgroundGrass() {
        return groundGrass;
    }
    
    public static int getgroundRoad() {
        return groundRoad;
    }
    
    public static int getairAir() {
        return airAir;
    }
    
    public static int getairCave() {
        return airCave;
    }
}
