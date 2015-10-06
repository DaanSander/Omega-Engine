package com.daansander.engine.math;

/**
 * Created by Daan on 3-10-2015.
 */
public class Vector2D {

    private int x;
    private int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Vector2D getLocation() {
        return new Vector2D(x, y);
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
