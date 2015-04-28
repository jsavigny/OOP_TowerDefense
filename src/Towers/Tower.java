package Towers;

import Noname.Screen;
import java.awt.*;

/**
 * Created by Julio on 4/27/2015.
 */
public abstract class Tower extends Rectangle {
    protected Rectangle towerSquare;
    protected int shotCreep = -1;
    protected int loseFrame = 0;
    protected boolean shooting = false;
    
    public Tower(){}
    
    public abstract int getTowerSquareSize();
    
    public abstract int getLoseTime();

    public void physics() {
        if (shotCreep != -1 && towerSquare.intersects(Screen.getCreeps(shotCreep))) {
            shooting = true;
        } else {
            shooting = false;
        }

        if (!shooting) {
            for (int i = 0; i < Screen.getCreeps().size(); i++) {
                if (Screen.getCreeps(i).isInGame()) {
                    if (towerSquare.intersects(Screen.getCreeps(i))) {
                        shooting = true;
                        shotCreep = i;
                    }
                }
            }

        }

        if (shooting) {
            if (loseFrame >= getLoseTime()) {
                Screen.getCreeps(shotCreep).loseHealth(getDamage());
                loseFrame = 0;
            } else {
                loseFrame += 1;
            }

            if (Screen.getCreeps(shotCreep).isDeath()) {
                shooting = false;
                shotCreep = -1;
            }
        }
    }
    
    public abstract void attack(Graphics g);
    
    public abstract int getDamage();
}
