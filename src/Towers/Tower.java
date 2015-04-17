package Towers;

/**
 * Created by Julio on 4/17/2015.
 */
public interface Tower {
    private double damage;
    private double attackSpeed;
    private double attackRange;
    private int cost;

    public void attack();
    public void upgradeLevel();
}
