package Noname;

import java.awt.*;
import Towers.*;
import Value.*;

/**
 *
 * @author husnimun
 */
public class Store {
    private int shopWidth = 8;
    private int buttonSize = 52;
    private int cellSpace = 2;
    private int itemIn = 4;
    private int heldID = -1;
    private int realID = -1;
    
    public static int[] towersID = {LaserTower.getID(), IceTower.getID(), -1, -1, -1, -1, -1, -1};
    public static int[] towersPrice = {LaserTower.getPrice(), IceTower.getPrice(), 0, 0, 0, 0, 0, 0};
    private Rectangle[] button = new Rectangle[shopWidth];
    
    
    public boolean holdsItem = false;

    public Store() {
        define();
    }
    
    public void mouseClick(int mouseButton) {
        if (mouseButton == 1) {
            for (int i = 0; i < button.length; i++) {
                if (button[i].contains(Screen.getMse())) {
                    if (towersID[i] != Value.getInstance().getairAir()) {
                        heldID = towersID[i];
                        realID = i;
                        holdsItem = true;
                    }
                }
            }
        }
    }
    
    public void mouseReleased(int mouseButton) {
        if (holdsItem && Screen.getPlayer().getCoins() >= towersPrice[realID]) {
            for (int y = 0; y < Screen.getBoard().getBlock().length; y++) {
                for (int x = 0; x < Screen.getBoard().getBlock(0).length; x++) {
                    if (Screen.getBoard().getBlock(y, x).contains(Screen.getMse())) {
                        if (Screen.getBoard().getBlock(y, x).getGroundID() < Value.getInstance().getgroundRoad() && Screen.getBoard().getBlock(y, x).getAirID() == Value.getInstance().getairAir()) {
                            Screen.getBoard().getBlock(y, x).setAirID(heldID);
                            Screen.getPlayer().addCoins(-towersPrice[realID]);
                        }
                    }
                }
            }
        }
        holdsItem = false;
    }
    
    public void define() {
        for (int i = 0; i < button.length; i++) {
            button[i] = new Rectangle(Screen.getMyWidth()/2 - shopWidth*(buttonSize+cellSpace)/2 + (buttonSize+cellSpace)*i, Screen.getBoard().getBlock(Screen.getBoard().getWorldHeight()-1, 0).y + Screen.getBoard().getBlockSize() + 20, buttonSize, buttonSize);
        }
    }
    
    public void draw(Graphics g) {
        // Draw item
        for (int i = 0; i < button.length; i++) {
            if (button[i].contains(Screen.getMse())) {
                g.setColor(new Color(255, 255, 255, 150));
                g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
            }
            g.drawImage(Screen.getTilesetRes(0), button[i].x, button[i].y, button[i].width, button[i].height, null);
            
            if (towersID[i] != Value.getInstance().getairAir()) {
                g.drawImage(Screen.getTilesetAir(towersID[i]), button[i].x + itemIn, button[i].y + itemIn, button[i].width - itemIn*2, button[i].height - itemIn*2, null);
            }
            if (towersPrice[i] > 0) {
                g.setColor(new Color(255, 255, 255));
                g.setFont(new Font("Courier New", Font.BOLD, 14));
                g.drawString("$" + towersPrice[i], button[i].x + 4, button[i].y + 12);
            }
        }
        
        // draw held item
        if (holdsItem) {
            g.drawImage(Screen.getTilesetAir(heldID), Screen.getMse().x - (button[0].width - itemIn*2)/2 - itemIn, Screen.getMse().y - (button[0].height - itemIn*2)/2 - itemIn, button[0].width , button[0].height, null);
        }
    }
}
