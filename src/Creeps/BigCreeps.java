package Creeps;

import java.awt.*;

/**
 * Created by Julio on 4/16/2015.
 */
public class BigCreeps implements Creep {
    private double maxHealth;
    private double curHealth;
    private Point position;
    private double moveSpeed;
    public void BigCreeps(){
        maxHealth=25;
        curHealth=25;
        position=spawnPoint;
        moveSpeed=5;
    }
    public void move(){}


}
