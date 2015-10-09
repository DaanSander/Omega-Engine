package com.daansander.engine.component;

import com.daansander.engine.math.Vector2D;

/**
 * Created by Daan on 21-9-2015.
 */
public abstract class Component {

    protected int width;
    protected int height;
    private Vector2D pos;

    public Component(Vector2D pos, int width, int height) {
        this.pos = pos;

        this.width = width;
        this.height = height;
    }

    public Vector2D getPos() {
        return pos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
