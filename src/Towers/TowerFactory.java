/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

/**
 *
 * @author ACER E1 471
 */
public class TowerFactory {
    public Tower getTower(int x, int y, int width, int height, int airID) {
        if (airID == 1) {
            return new IceTower(x,y,width,height);
        }
        else if (airID == 2) {
            return new LaserTower(x,y,width,height);
        }
        return null;
    }
}
