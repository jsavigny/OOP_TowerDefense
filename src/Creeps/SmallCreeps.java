package Creeps;

import java.awt.*;

/**
 * Created by Julio on 4/16/2015.
 */
public class SmallCreeps implements Creep {
    private double maxHealth;
    private double curHealth;
    private Point position;
    private double moveSpeed;
    public void SmallCreeps(){
        maxHealth=10;
        curHealth=10;
        position=spawnPoint;
        moveSpeed=5;
    }
    public void move(){}
}
