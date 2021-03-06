package Gameplay;

import java.awt.*;

import Creeps.Creep;
import Value.*;

/**
 *
 * @author husnimun
 */
public class Board {
    private int worldWidth = 12;
    private int worldHeight = 8;
    private int blockSize = 52;
    
    private Block[][] block;
    
    public Board() {
        define();
    }
    
    public void define() {
        block = new Block[worldHeight][worldWidth];
        
        for (int y = 0; y < block.length; y++ ) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x] = new Block((Screen.getMyWidth()/2) - (worldWidth*blockSize/2) + (x * blockSize), y * blockSize, blockSize, blockSize, Value.getInstance().getgroundRoad(), Value.getInstance().getairAir());
                
            }
        }
    }
    
    public void physics() {
        for (int y = 0; y < block.length; y++ ) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x].physics(); 
            }
        }
    }
    
    public void draw(Graphics g) {
        for (int y = 0; y < block.length; y++ ) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x].draw(g); 
            }
        }
        
        for (int y = 0; y < block.length; y++ ) {
            for (int x = 0; x < block[0].length; x++) {
                block[y][x].attack(g); 
            }
        }
    }
    
    public int getWorldWidth() { return worldWidth; }
    
    public int getWorldHeight() { return worldHeight; }
    
    public int getBlockSize() { return blockSize; }
    
    public Block[][] getBlock() { return block; }
    
    public Block[] getBlock(int i) { return block[i]; }
    
    public Block getBlock(int x, int y) { return block[x][y]; }
    private int spawnTime = 2000, spawnFrame = 0;
    public void creepSpawner() {
        if (spawnFrame >= spawnTime && !Screen.getPlayer().isWin() && !Screen.getPlayer().isGameOver()) {
            for (Creep creep : Screen.getCreeps()) {
                if (!creep.isInGame()) {
                    creep.spawnCreep();
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame += 1;
        }
    }
}
