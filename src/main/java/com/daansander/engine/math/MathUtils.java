package com.daansander.engine.math;

import com.daansander.engine.Engine;

/**
 * Created by Daan on 28-9-2015.
 */
public class MathUtils extends Engine {

    private int deg = 0;

    public MathUtils() {
        super();
    }

    public static Vector2D getPointCircle(int r, int xo, int yo, int deg) {
        double c = Math.cos(deg);
        double s = Math.sin(deg);

        long x = Math.round(c);
        long y = Math.round(s);

        int fx = xo + r * (int) x;
        int fy = yo + r * (int) y;

        return new Vector2D(fx, fy);
    }

    public static void main(String[] args) {
        new MathUtils();
    }

    @Override
    public void update() {
//        if(deg < 360) {
//            Vector2D c = getPointCircle(5, 20, 20, deg);
//            System.out.println("x " + c.getX() + ", y " + c.getY());
//            getScreen().render(c.getX(), c.getY(), 0xffffff);
//        }
        deg += 90;
    }
}
