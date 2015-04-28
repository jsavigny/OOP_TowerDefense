package Towers;

import Noname.Screen;
import Value.Value;
import java.awt.*;

/**
 * Created by Julio on 4/27/2015.
 */
public class IceTower extends Tower {
    private static int airID = 2;
    private static int price = 15;
    private int towerSquareSize = 130;
    private int loseTime = 100;
    private int damage = 1;
    
    public IceTower(int x, int y, int width, int height) {
        towerSquare = new Rectangle(x - towerSquareSize/2, y - towerSquareSize/2, width + towerSquareSize, height + towerSquareSize);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int getTowerSquareSize() {
        return towerSquareSize;
    }
   
    public void attack(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        
        g.setColor(new Color(1, 240, 250));
        // g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);

        if (shooting && loseFrame >= loseTime - 100) {
            g2.setStroke(new BasicStroke(2));
            g.drawLine(x + width/2, y + height/2, Screen.getCreeps(shotCreep).x + Screen.getCreeps(shotCreep).width/2, Screen.getCreeps(shotCreep).y + Screen.getCreeps(shotCreep).height/2);
        }
    }
    
    public static int getID() { return airID; }
    
    public static int getPrice() { return price; }
    
    public int getDamage() { return damage; }
    
    public int getLoseTime() { return loseTime; } 
}
