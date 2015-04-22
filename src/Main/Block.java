package Main;

import java.awt.*;


/**
 *
 * @author husnimun
 */
public class Block extends Rectangle {
    public Rectangle towerSquare;
    public int towerSquareSize = 130;
    
    public int groundID;
    public int airID;
    public int loseTime = 100, loseFrame = 0;
    
    public int shotMob = -1;
    
    public boolean shooting = false;
    
    public Block(int x, int y, int width, int height, int groundID, int airID) {
        setBounds(x, y, width, height);
        towerSquare = new Rectangle(x - towerSquareSize/2, y - towerSquareSize/2, width + towerSquareSize, height + towerSquareSize);
        this.groundID = groundID;
        this.airID = airID;
    }
    
    public void draw(Graphics g) {
        g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);
        
        if (airID != Value.airAir) {
            g.drawImage(Screen.tileset_air[airID], x, y, width, height, null);
        }
        
    }
    
    public void physics() {
        if (shotMob != -1 && towerSquare.intersects(Screen.creeps[shotMob])) {
            shooting = true;
        } else {
            shooting = false;
        }
        
        if (!shooting) {
            if (airID == Value.airTowerLaser) {
                for (int i = 0; i < Screen.creeps.length; i++) {
                    if (Screen.creeps[i].inGame) {
                        if (towerSquare.intersects(Screen.creeps[i])) {
                            shooting = true;
                            shotMob = i;
                        }
                    }
                }
            }
        }
        
        if (shooting) {
            if (loseFrame >= loseTime) {
                Screen.creeps[shotMob].loseHealth(1);
                loseFrame = 0;
            } else {
                loseFrame += 1;
            }
            
            if (Screen.creeps[shotMob].isDeath()) {
                shooting = false;
                shotMob = -1;
            }
        }
    }
    
    public void getMoney(int mobID) {
        Screen.coins += Value.deathReward[mobID];
    }
    
    public void attack(Graphics g) {
        if (Screen.isDebug) {
           if (airID == Value.airTowerLaser) {
                g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            } 
        }
        
        if (shooting) {
            g.setColor(new Color(255, 255, 0));
            g.drawLine(x + width/2, y + height/2, Screen.creeps[shotMob].x + Screen.creeps[shotMob].width/2, Screen.creeps[shotMob].y + Screen.creeps[shotMob].height/2);
        }
    }
}
