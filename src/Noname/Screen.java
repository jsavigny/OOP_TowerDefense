package Noname;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;

import EventHandler.*;
import Map.*;
import Creeps.*;

/**
 *
 * @author husnimun
 */
public class Screen extends JPanel implements Runnable {
    public Thread thread = new Thread(this);
    private boolean isFirst = true;
    
    private static Point mse = new Point(0, 0);
    private static int myWidth, myHeight;
    private int creepCount = 0;
    
    private Image background;
    private static Image[] tilesetGround = new Image[100];
    private static Image[] tilesetAir = new Image[100];
    private static Image[] tilesetRes = new Image[100];
    private static Image[] tilesetCreep = new Image[2];
    
    private static Board board;
    private Map map;
    private static Store store;
    private static Player player;
    private static ArrayList<Creep> creeps = new ArrayList<>();
    
    public Screen(Frame frame) {
        frame.addMouseListener(new KeyHandler());
        frame.addMouseMotionListener(new KeyHandler());
        thread.start();
    }
    
    public void define() {
        board = new Board();
        map = new Map();
        store = new Store();
        player = new Player();
        
        background = new ImageIcon("res/background.png").getImage();
        
        for (int i = 0; i < tilesetGround.length; i++) {
            tilesetGround[i] = new ImageIcon("res/tileset_ground.png").getImage();
            tilesetGround[i] = createImage(new FilteredImageSource(tilesetGround[i].getSource(), new CropImageFilter(0, 52 * i, 52, 52)));
        }
        
        for (int i = 0; i < tilesetAir.length; i++) {
            tilesetAir[i] = new ImageIcon("res/tileset_air.png").getImage();
            tilesetAir[i] = createImage(new FilteredImageSource(tilesetAir[i].getSource(), new CropImageFilter(0, 52 * i, 52, 52)));
        }
        
        for (int i = 0; i < tilesetCreep.length; i++) {
            tilesetCreep[i] = new ImageIcon("res/tileset_creep.png").getImage();
            tilesetCreep[i] = createImage(new FilteredImageSource(tilesetCreep[i].getSource(), new CropImageFilter(0, 52 * i, 52, 52)));
        }
        
        tilesetRes[0] = new ImageIcon("res/cell.png").getImage();
        tilesetRes[1] = new ImageIcon("res/heart.png").getImage();
        tilesetRes[2] = new ImageIcon("res/coin.png").getImage();
        
        map.load(new File("save/mission1"));
        
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Creep creep = new WeakCreep();
                creeps.add(creep);
                System.out.println("boooom2");
            } else {
                Creep creep = new StrongCreep();
                creeps.add(creep);
                System.out.println("boooom");
            }
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
        
        g.drawImage(background, board.getBlock(0, 0).x , 0, 624, 416, null);

        // drawing the board
        g.setColor(new Color(0, 0, 0));
        board.draw(g);
        for (Creep creep : creeps) {
            if (creep.isInGame()) {
                creep.draw(g);
            }
        }
        store.draw(g);
        player.draw(g);
        
        if (player.isWin()) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, myWidth, myHeight);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("You Win!", myWidth/2 - 55, myHeight/2);
            
        } else if (player.isGameOver()) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, myWidth, myHeight);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Game Over", myWidth/2 - 55, myHeight/2);
        }
    }
    

    
    @Override
    public void run() {
        while(true) {
            if (!isFirst) {
                board.physics();
                board.creepSpawner();
                for (Creep creep : creeps) {
                    if (creep.isInGame()) {
                        creep.physics();
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
    
    // Setter and getter
    
    public static Point getMse() { return mse; }

    public static void setMse(Point _mse) { mse = _mse; }

    public static int getMyWidth() { return myWidth; }

    public static int getMyHeight() { return myHeight; }
    
    public static Board getBoard() { return board; }
    
    public static Store getStore() { return store; }
    
    public static Image getTilesetGround(int i) { return tilesetGround[i]; }
    
    public static Image getTilesetAir(int i) { return tilesetAir[i]; }
    
    public static Image getTilesetRes(int i) { return tilesetRes[i]; }
    
    public static Image getTilesetCreep(int i) { return tilesetCreep[i]; }
    
    public static Player getPlayer() { return player; }
    
    public static Creep getCreeps (int i) { return creeps.get(i); }
    
    public static ArrayList<Creep> getCreeps() { return creeps; }
}
