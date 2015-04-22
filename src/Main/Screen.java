package Main;

import Creep.Creep;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;

/**
 *
 * @author husnimun
 */
public class Screen extends JPanel implements Runnable {
    
    public Thread thread = new Thread(this);
    
    public static Image[] tileset_ground = new Image[100];
    public static Image[] tileset_air = new Image[100];
    public static Image[] tileset_res = new Image[100];
    public static Image[] tileset_creep = new Image[100];
    
    public static boolean isFirst = true;
    public static boolean isDebug = true;
    
    public static Point mse = new Point(0, 0);
    
    public static int myWidth, myHeight;
    public static int coins = 10, health = 100;
    
    public static Save save;
    public static Room room;
    public static Store store;
    public static Creep[] creeps = new Creep[100];
    
    
    public Screen(Frame frame) {
        frame.addMouseListener(new KeyHandel());
        frame.addMouseMotionListener(new KeyHandel());
        
        thread.start();
    }
    
    public void define() {
        room = new Room();
        save = new Save();
        store = new Store();
        
        for (int i = 0; i < tileset_ground.length; i++) {
            tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26 * i, 26, 26)));
        }
        
        for (int i = 0; i < tileset_air.length; i++) {
            tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 52 * i, 52, 52)));
        }
        
        tileset_res[0] = new ImageIcon("res/cell.png").getImage();
        tileset_res[1] = new ImageIcon("res/heart.png").getImage();
        tileset_res[2] = new ImageIcon("res/coin.png").getImage();
        
        tileset_creep[0] = new ImageIcon("res/mob.png").getImage();
        
        save.loadSave(new File("save/mission1"));
        
        // define creep
        for (int i = 0; i < creeps.length; i++) {
            creeps[i] = new Creep();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if (isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();
            define();
            
            isFirst = false;
        }
        
        g.setColor(new Color(70, 70, 70));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // drawing the room
        g.setColor(new Color(0, 0, 0));
        room.draw(g); 
        
        // drawing the creeps
        for (Creep creep : creeps) {
            if (creep.inGame) {
                creep.draw(g);
            }
        }
        
        // drawing the store
        store.draw(g); 
    }
    
    public int spawnTime = 2400, spawnFrame = 0;
    public void mobSpawner() {
        if (spawnFrame >= spawnTime) {
            for (Creep mob : creeps) {
                if (!mob.inGame) {
                    mob.spawnMob(Value.creepGreen);
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame += 1;
        }
    }
    
    @Override
    public void run() {
        while(true) {
            if (!isFirst) {
                room.physics();
                mobSpawner();
                for (Creep mob : creeps) {
                    if (mob.inGame) {
                        mob.physics();
                    }
                }
            }
            
            repaint();
            
            try {
                Thread.sleep(1);
            }
            catch (Exception e) { }
        }
    }
}
