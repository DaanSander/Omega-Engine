package com.daansander.engine.math;

import com.daansander.engine.Engine;

import java.util.HashMap;

/**
 * Created by Daan on 28-9-2015.
 */
public class MathUtils extends Engine {

    //TODO make vector 2D class

    public MathUtils() {
        super();
    }

    public static void main(String[] args) {
        new MathUtils();
    }

    public HashMap<Vector2D, Integer> drawCircle(int radius, Vector2D vector2D) {

        return null;
    }

    @Override
    public void update() {
        /*boolean t = true;
        if(t) {
            drawCircle(2,new Vector2D(20, 20));
            t = false;
        }*/
        draw();
    }

    public void draw() {
        getGraphics();
    }
}
