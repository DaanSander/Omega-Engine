package com.daansander.engine.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Daan on 17-9-2015.
 */
public abstract class Render extends Graphics implements Runnable {

    private final RenderType type;
    private final int delay;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private String fps = "";
    private volatile boolean running = false;

    public Render(boolean r, String name, int width, RenderType type, int delay) {
        super(width, 2, name, r);
        this.type = type;
        this.delay = delay;

        start();
    }

    public synchronized void start() {
        running = true;
        new Thread(this, "Render").start();
    }

    public synchronized void stop() {

    }

    public void init() {

    }

    public void render() {
        update();
    }

    public void tick() {
        super.tick();
    }



    public void run() {
        switch (type) {
            case NANOSECOND:
                long lastTime = System.nanoTime();
                long timer = System.currentTimeMillis();

                final double ns = 1000000000D / 60D;
                double delta = 0;

                int ticks = 0;
                int frames = 0;

                while (running) {
                    long current = System.nanoTime();

                    delta += (current - lastTime) / ns;
                    lastTime = current;

                    while (delta >= 1) {
                        tick();
                        ticks++;

                        delta--;
                    }

                    render();
                    frames++;


                    if (System.currentTimeMillis() - timer >= 1000) {
                        timer += 1000;
//                        System.out.println("FPS " + frames + " TPS " + ticks);

                        fps = String.format("FPS %s, TPS %2$s", frames, ticks);

//                        System.out.println(fps);
                        frames = 0;
                        ticks = 0;
                    }

                }
                break;
            case MILISECOND:
                long last = System.currentTimeMillis();
                long current;
                long deltaTime = 0;

                int frame = 0;
                //        int ticks = 0;

                while (running) {
                    current = System.currentTimeMillis();
                    deltaTime += current - last;
                    last = current;
                    frame++;

                    if (deltaTime > 1000) {
                        deltaTime -= 1000;

                        fps = String.format("FPS %s, TPS %2$s", frame, -1);
//                        System.out.println(fps);

                        frame = 0;

                    }

                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    render();
                    tick();
                }
                break;
        }
    }

    public abstract void update();

    public String getFps() {
        return fps;
    }
}
