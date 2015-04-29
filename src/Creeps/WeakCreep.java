/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creeps;

import Gameplay.Screen;

/**
 *
 * @author ACER E1 471
 */
public class WeakCreep extends Creep {
    private final int bounty = 2;
    private final int creepID = 0;
    private final int damage = 10;
    private int walkSpeed = 15;
    private double iHealth = 52;
    private final int maxHealth = 52;
    public WeakCreep() {

    }

    public int getBounty() {
        return bounty;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public double getHealth() {
        return iHealth;
    }

    public int getCreepID() {
        return creepID;
    }

    public int getDamage() {
        return damage;
    }

    public double getMaxHealth(){ return maxHealth; }

}
