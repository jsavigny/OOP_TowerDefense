package Creeps;
/**
 * Created by Julio on 4/16/2015.
 */
import java.awt.*;
import java.awt.geom.Rectangle2D;

public interface Creep extends Rectangle2D {
    private double maxHealth;
    private double curHealth;
    private Point position;
    private double moveSpeed;
    public void move();
}
