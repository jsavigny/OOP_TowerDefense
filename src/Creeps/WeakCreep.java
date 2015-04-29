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
<<<<<<< HEAD
    private double iHealth = 52;
    private final int maxHealth = 52;
=======
    private int iHealth = 52;

>>>>>>> bc7954fd12f4dd063414a8d55cc469fb62849bb4
    public WeakCreep() {

    }

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

    public double getMaxHealth(){ return maxHealth; }

}
