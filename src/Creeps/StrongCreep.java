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
<<<<<<< HEAD
    private double iHealth = 78;
    private final int maxHealth = 78;
=======
    private int iHealth = 78;
>>>>>>> bc7954fd12f4dd063414a8d55cc469fb62849bb4

    public StrongCreep() { }

    public int getBounty() {
        return bounty;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

<<<<<<< HEAD
    public double getHealth() {
=======
    public int getHealth() {
>>>>>>> bc7954fd12f4dd063414a8d55cc469fb62849bb4
        return iHealth;
    }

    public int getCreepID() {
        return creepID;
    }

    public int getDamage() {
        return damage;
    }

<<<<<<< HEAD
    public double getMaxHealth(){ return maxHealth; }
=======
>>>>>>> bc7954fd12f4dd063414a8d55cc469fb62849bb4
}
