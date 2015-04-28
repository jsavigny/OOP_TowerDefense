package Noname;

import java.awt.*;
import Value.*;
import Towers.*;
/**
 *
 * @author husnimun
 */
public class Block extends Rectangle {
    private int groundID;
    private int airID;
    
    private Tower tower;
    
    public Block(int x, int y, int width, int height, int groundID, int airID) {
        setBounds(x, y, width, height);
        this.groundID = groundID;
        this.airID = airID;
    }
    
    public void draw(Graphics g) {
        g.drawImage(Screen.getTilesetGround(groundID), x, y, width, height, null);
        
        if (airID != Value.getairAir()) {
            g.drawImage(Screen.getTilesetAir(airID), x, y, width, height, null);
        }
        
    
    }
    
    public void attack(Graphics g) {
        if (tower != null) {
            tower.attack(g);
        }    
    }
    
    public void physics() {
        if (tower == null) {
            switch (airID){
                case 1 :
                    tower = new IceTower(x, y, width, height);
                    break;
                case 2 :
                    tower = new LaserTower(x, y, width, height);
                    break;
            }
        } else {
            tower.physics();
        }
    }
    
    public int getGroundID() { return groundID; }
    
    public void setGroundID(int groundID) { this.groundID = groundID; }
    
    public int getAirID() { return airID; }
    
    public void setAirID(int airID) { this.airID = airID; }
    
}
