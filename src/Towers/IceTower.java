package Towers;

/**
 * Created by Julio on 4/17/2015.
 */
public class IceTower implements Tower {
    private double damage;
    private double attackSpeed;
    private double attackRange;
    private int cost;
    private double slowRate;
    IceTower(){

    }
    public void attack(){
        //Method Attack
    }
    public void upgradeLevel(){
        damage+=10;
        attackSpeed+=1;
        slowRate+=1;
        attackRange+=1;
    }
    public int getCost(){
        return cost;
    }
    public double getDamage(){
        return damage;
    }
    public double getAttackSpeed(){
        return attackSpeed;
    }
    public double getAttackRange(){
        return attackRange;
    }
    public double getSlowRate(){
        return slowRate;
    }
}
