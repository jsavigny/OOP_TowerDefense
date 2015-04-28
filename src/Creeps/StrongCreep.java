/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creeps;

import Noname.Screen;

/**
 *
 * @author ACER E1 471
 */
public class StrongCreep extends Creep {
    private final int bounty = 4;
    private int walkSpeed = 25;
    private int health = 100;
    
    public StrongCreep() { }
    
    public int getBounty() {
        return bounty;
    }
    
    public int getWalkSpeed() {
        return walkSpeed;
    }
    
    public int getHealth() {
        return health;
    }
}
