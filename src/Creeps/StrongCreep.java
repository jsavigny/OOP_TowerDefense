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
    private final int creepID = 1;
    private final int damage = 20;
    private int walkSpeed = 10;
    private int iHealth = 78;

    public StrongCreep() { }

    public int getBounty() {
        return bounty;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public int getHealth() {
        return iHealth;
    }

    public int getCreepID() {
        return creepID;
    }

    public int getDamage() {
        return damage;
    }

}
