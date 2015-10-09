package com.daansander.engine.component;


import com.daansander.engine.input.ComponentHandler;
import com.daansander.engine.math.Vector2D;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Daan on 8-10-2015.
 */
public class ListenerComponent extends ComponentHandler {

    protected ArrayList<Vector2D> cpos = new ArrayList<>();
    protected Vector2D mousePos;
    protected Vector2D pos;
    protected boolean mouseDown = false;
    protected Component c;

    public ListenerComponent(Component component) {
        this.c = component;
        this.pos = component.getPos();
        mousePos = new Vector2D(0, 0);
    }


    public boolean onComponent() {
        for (Vector2D v : cpos) {
            if (mousePos == v) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mouseDown(MouseEvent mouseEvent) {
        mouseDown = true;
    }

    @Override
    public void mouseUp(MouseEvent mouseEvent) {
        mouseDown = false;
    }

    @Override
    public void mouseMove(MouseEvent e) {
        mousePos.setLocation(e.getX(), e.getY());
        for (int i = 0; i < c.getWidth(); i++) {
            for (int j = 0; j < c.getHeight(); j++) {
                cpos.add(new Vector2D(i, j));
            }
        }
        onComponent();

    }

    public Vector2D getMousePos() {
        return mousePos;
    }

    public Vector2D getPos() {
        return pos;
    }

    public boolean isMouseDown() {
        return mouseDown;
    }
}
