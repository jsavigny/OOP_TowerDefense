package EventHandler;

import java.awt.event.*;
import java.awt.Point;
import Noname.*;

import Main.*;

/**
 *
 * @author husnimun
 */
public class KeyHandler implements MouseMotionListener, MouseListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        Screen.setMse(new Point(e.getX() - (Frame.getTheSize().width - Screen.getMyWidth())/2, e.getY() - (Frame.getTheSize().height - Screen.getMyHeight()) + (Frame.getTheSize().width - Screen.getMyWidth())/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Screen.setMse(new Point(e.getX() - (Frame.getTheSize().width - Screen.getMyWidth())/2, e.getY() - (Frame.getTheSize().height - Screen.getMyHeight()) + (Frame.getTheSize().width - Screen.getMyWidth())/2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       Screen.getStore().mouseClick(e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Screen.getStore().mouseReleased(e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
