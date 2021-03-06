package com.daansander.engine.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author Daan Meijer
 * @since 0.1
 */
public abstract class Render extends Graphics implements Runnable {

    //TODO: Add easy draw methods
    //TODO: Fix draw method

    private final RenderType type;
    private final int delay;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private String fps = "";
    private volatile boolean running = false;

    /**
     * @param r     can riseze screeb
     * @param name  of screen
     * @param width of screen
     * @param type  rendertype
     * @param delay of render
     * @see RenderType
     * @see Graphics
     */
    public Render(boolean r, String name, int width, RenderType type, int delay) {
        super(width, 2, name, r);
        this.type = type;
        this.delay = delay;

        init();
    }

    public synchronized void start() {
        running = true;
        new Thread(this, "Render").start();
    }

    public synchronized void stop() {
        running = false;
    }

    public void init() {

        start();
    }

    public void render() {
        getScreen().clear();

        update();

        getScreen().render();

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = getScreen().pixels[i];
        }
        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        graphics.dispose();
        bs.show();

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
