package Gameplay;

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
        
        if (airID != Value.getInstance().getairAir()) {
            g.drawImage(Screen.getTilesetAir(airID), x, y, width, height, null);
        }
        
    
    }
    
    public void attack(Graphics g) {
        if (tower != null) {
            tower.attack(g);
        }    
    }
    
    public void physics() {
        if ((tower == null) && (airID != -1)) {
            TowerFactory towerFactory = new TowerFactory();
            tower = towerFactory.getTower(x, y, width, height,airID);
        } else {
            try {
                tower.physics();
            } catch (Exception e) { }
        }
    }
    
    public int getGroundID() { return groundID; }
    
    public void setGroundID(int groundID) { this.groundID = groundID; }
    
    public int getAirID() { return airID; }
    
    public void setAirID(int airID) { this.airID = airID; }
    
}
