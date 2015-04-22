package Creep;

import Main.Screen;
import Main.Value;
import java.awt.*;

/**
 *
 * @author husnimun
 */
public class Creep extends Rectangle {
    public int xC, yC;
    public int health;
    public int creepSize = 52;
    public int creepWalk = 0;
    public int upward = 0, downward = 1, right = 2, left = 3;
    public int direction = right;
    public int creepID = Value.creepAir;
    
    public boolean inGame = false;
    public boolean hasUpward = false;
    public boolean hasDownward = false;
    public boolean hasRight = false;
    public boolean hasLeft = false;
    
    public Creep() {
        
    }
    
    public void spawnMob(int mobID) {        
        for (int y = 0; y < Screen.room.block.length; y++) {
            if (Screen.room.block[y][0].groundID == Value.groundRoad) {
                setBounds(Screen.room.block[y][0].x, Screen.room.block[y][0].y, creepSize, creepSize);
                xC = 0;
                yC = y;
            }
        }
        
        this.creepID = mobID;
        inGame = true;
        health = creepSize;
    }
    
    public int walkFrame = 0, walkSpeed = 20;
    public void physics() {
        if (walkFrame >= walkSpeed) {
            if (direction == right) {
                x += 1;
            } else if (direction == left) {
                x -= 1;
            } else if (direction == upward) {
                y -= 1;
            } else if (direction == downward) {
                y += 1;
            }
           
           creepWalk += 1;
           if (creepWalk == Screen.room.blockSize) {
                if (direction == right) {
                    xC += 1;
                    hasRight = true;
                } else if (direction == left) {
                    xC -= 1;
                    hasLeft = true;
                } else if (direction == upward) {
                    yC -= 1;
                    hasUpward = true;
                } else if (direction == downward) {
                    yC += 1;
                    hasDownward = true;
                }
                
                try {
                    if (Screen.room.block[yC+1][xC].groundID == Value.groundRoad && !hasUpward) {
                        direction = downward;
                    } else if (Screen.room.block[yC-1][xC].groundID == Value.groundRoad && !hasDownward) {
                        direction = upward;
                    } else if (Screen.room.block[yC][xC+1].groundID == Value.groundRoad && !hasLeft) {
                        direction = right;
                    } else if (Screen.room.block[yC][xC-1].groundID == Value.groundRoad && !hasRight) {
                        direction = left;
                    }
                } catch (Exception e) { }
                
                if (Screen.room.block[yC][xC].airID == Value.airCave) {
                    deleteCreep();
                    looseHealth();
                }
                
                hasRight = false;
                hasLeft = false;
                hasUpward = false;
                hasDownward = false;
                creepWalk = 0;
           }
           
           walkFrame = 0;
        } else {
            walkFrame += 1;
        }
        
    }
    
    public void deleteCreep() {
        inGame = false;
        direction = right;
        creepWalk = 0;
    }
    
    public void looseHealth() {
        Screen.health -= 1;
    }
    
    public void loseHealth(int damage) {
        health -= damage;
        checkDeath();
    }
    
    public boolean isDeath() {
        return !inGame;
    }
    
    public void checkDeath() {
        if (health < 1) {
            deleteCreep();
        }
    }
    
    public void draw(Graphics g) {
        g.drawImage(Screen.tileset_creep[creepID], x, y, width, height, null);
        
        // draw health bar
        g.setColor(new Color(180, 50, 50));
        g.fillRect(x, y - 10, width, 3);

        // draw health
        g.setColor(new Color(50, 180, 50));
        g.fillRect(x, y - 10, health, 3);
        
        // draw outline for health baro;;
        g.setColor(new Color(0, 0, 0));
        g.drawRect(x, y - 10, width - 1, 2);
    }
}
