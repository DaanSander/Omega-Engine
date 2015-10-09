package com.daansander.engine.input;

import javax.swing.event.MouseInputListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Daan on 9-10-2015.
 */
public abstract class ComponentHandler implements MouseInputListener, MouseMotionListener, KeyListener, Runnable {

    public ComponentHandler() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDown(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseUp(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMove(e);
    }

    public abstract void mouseDown(MouseEvent mouseEvent);

    public abstract void mouseUp(MouseEvent mouseEvent);

    public abstract void mouseMove(MouseEvent e);

    @Override
    public void run() {

    }
}
