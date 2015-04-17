package Towers;

/**
 * Created by Julio on 4/17/2015.
 */
public class CannonTower implements Tower {
    private double damage;
    private double attackSpeed;
    private double attackRange;
    private int cost;
    private double splashRange;
    CannonTower(){
        //CTOR
    }
    public void attack(){
        //Method Attack
    }
    public void upgradeLevel(){
        damage+=10;
        attackSpeed+=1;
        attackRange+=1;
        splashRange+=1;
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
    public double getSplashRange(){
        return splashRange
    }
}
