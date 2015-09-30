package com.daansander.engine.graphics;

/**
 * Created by Daan on 21-9-2015.
 */
public class Screen {

    public int pixels[];
    private int width;
    private int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void render() {

    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
