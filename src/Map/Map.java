package Map;

import java.io.*;
import java.util.*;

import Noname.*;

/**
 *
 * @author husnimun
 */
public class Map {
    public void load(File loadPath) {
        try {
            Scanner loadScanner = new Scanner(loadPath);
            
            while(loadScanner.hasNext()) {
                for (int y = 0; y < Screen.getBoard().getBlock().length; y++) {
                    for (int x = 0; x < Screen.getBoard().getBlock(0).length; x++) {
                        Screen.getBoard().getBlock(y, x).setGroundID(loadScanner.nextInt());   
                    }
                }
                
                for (int y = 0; y < Screen.getBoard().getBlock().length; y++) {
                    for (int x = 0; x < Screen.getBoard().getBlock(0).length; x++) {
                        Screen.getBoard().getBlock(y, x).setAirID(loadScanner.nextInt());
                    }
                }
            }
            
            loadScanner.close();
        } catch(Exception e) {
            
        } 
    }
}
