package Creeps;

import Noname.Screen;
import Value.Value;
import java.awt.*;
/**
 *
 * @author ACER E1 471
 */

public abstract class Creep extends Rectangle {
    private int xC, yC;
    private int health;
    private int creepSize = 52;
    private int creepWalk = 0;
    private static int upward = 0, downward = 1, right = 2, left = 3;
    private int direction = right;
    private int creepID = Value.getairAir();
    private int walkFrame = 0, walkSpeed = 10;
    private boolean inGame = false;
    private boolean hasUpward = false;
    private boolean hasDownward = false;
    private boolean hasRight = false;
    private boolean hasLeft = false;
    private int Reward;
    
    public int getxC() {
        return xC;
    }
    
    public int getyC() {
        return yC;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getcreepSize() {
        return creepSize;
    }
    
    public int getcreepWalk() {
        return creepWalk;
    }
    
    public int getdirection() {
        return direction;
    }
    
    public boolean isInGame() {
        return inGame;
    }
    
    public Creep() {
        
    }
    
    public void spawnCreep(int creepID) {        
        for (int y = 0; y < Screen.getBoard().getBlock().length; y++) {
            if (Screen.getBoard().getBlock(y,0).getGroundID() >= Value.getgroundRoad()) {
                setBounds(Screen.getBoard().getBlock(y,0).x, Screen.getBoard().getBlock(y,0).y, creepSize, creepSize);
                xC = 0;
                yC = y;
            }
        }
        
        this.creepID = creepID;
        inGame = true;
        health = creepSize;
    }
    
    public void physics() {
        int walkCount=0;
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
           if (creepWalk == Screen.getBoard().getBlockSize()) {
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
                    if (Screen.getBoard().getBlock(yC+1,xC).getGroundID() >= Value.getgroundRoad() && !hasUpward) {
                        direction = downward;
                    } else if (Screen.getBoard().getBlock(yC-1,xC).getGroundID() >= Value.getgroundRoad() && !hasDownward) {
                        direction = upward;
                    } else if (Screen.getBoard().getBlock(yC,xC+1).getGroundID() >= Value.getgroundRoad() && !hasLeft) {
                        direction = right;
                    } else if (Screen.getBoard().getBlock(yC,xC-1).getGroundID() >= Value.getgroundRoad() && !hasRight) {
                        direction = left;
                    }
                } catch (Exception e) { }
                
                if (Screen.getBoard().getBlock(yC,xC).getAirID() == Value.getairCave()) {
                    deleteCreep();
                    Screen.getPlayer().loseHealth();
                }
                
                hasRight = false;
                hasLeft = false;
                hasUpward = false;
                hasDownward = false;
                creepWalk = 0;
           }
           walkCount++;
           if (walkCount==10){
               walkCount=0;
               walkSpeed=10;
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
        Screen.getPlayer().addCoins(getBounty());
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        
        g.drawImage(Screen.getTilesetCreep(creepID), x, y, width, height, null);
        
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
    
    public void slowSpeed (int x)
    {
        walkSpeed += x;
    }
    
    public abstract int getBounty();
}
