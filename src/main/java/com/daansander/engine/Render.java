package com.daansander.engine;

import com.daansander.engine.graphics.Graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Daan on 17-9-2015.
 */
public class Render extends Graphics implements Runnable {

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Render() {
        super(0, 0, "", true);

    }

    public synchronized void start() {

    }

    public synchronized void stop() {

    }

    public void init() {

    }

    public void render() {

    }

    public void tick() {
        super.tick();
    }


    public void run() {

    }
}
