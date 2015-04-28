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
public class WeakCreep extends Creep {
    private final int bounty = 2;
    private final int creepID = 0;
    private final int damage = 10;
    private int walkSpeed = 15;
    private int health = 50;
    
    public WeakCreep() {
        
    }
    
    public int getBounty() {
        return bounty;
    }
    
    public int getWalkSpeed() {
        return walkSpeed;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getCreepID() {
        return creepID;
    }
    
    public int getDamage() {
        return damage;
    }
}
