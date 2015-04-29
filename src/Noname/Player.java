package Noname;

import java.awt.*;

/**
 *
 * @author husnimun
 */
public class Player {
    private final int killsToWin = 20;
    private int coins = 100;
    private int lives = 100;
    private int iconSize = 20;
    private int killCount = 0;
    
    public Rectangle buttonHealth;
    public Rectangle buttonCoins;
    
    public Player() {
        define();
    }
    
    public void addCoins(int n){
        coins += n;
    }
    
    public boolean isWin() {
        return killCount >= killsToWin;
    }
    
    public boolean isGameOver() {
        return lives <= 0;
    }
    
    public void loseHealth(int damage){
        lives -= damage;
    }
    
    public void define() {
        buttonHealth = new Rectangle(Screen.getBoard().getBlock(0, 0).x, 435, iconSize, iconSize);
        buttonCoins = new Rectangle(Screen.getBoard().getBlock(0, 0).x, 485 - iconSize, iconSize, iconSize);
    }
    
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        // draw health icon
        g.drawImage(Screen.getTilesetRes(1), buttonHealth.x, buttonHealth.y, iconSize, iconSize, null);
        // draw coin icon
        g.drawImage(Screen.getTilesetRes(2), buttonCoins.x, buttonCoins.y, iconSize, iconSize, null);
        
        g.drawString("" + lives, buttonHealth.x + buttonHealth.width + 3, buttonHealth.y + 14);
        g.drawString("" + coins, buttonCoins.x + buttonCoins.width + 3, buttonCoins.y + 14);
    }
    
    public int getCoins() { return coins; }
    public int getLives() { return lives; }
    public int getKillCount() { return killCount; }
    public void setKillCount(int n) { killCount = n; }
    public void addKillCount(int n) { killCount += n; }    
}
