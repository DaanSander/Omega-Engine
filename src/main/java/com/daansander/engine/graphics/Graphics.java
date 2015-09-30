package com.daansander.engine.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Daan on 19-9-2015.
 */
public abstract class Graphics extends Canvas {

    //TODO: Include Components!
    //TODO: Add/Write Screen class!

    protected final String NAME;
    protected final boolean locked;
    protected int WIDTH = 0;
    protected int HEIGHT;
    protected int SCALE = 3;
    protected java.awt.Graphics graphics;
    protected BufferStrategy bs;

    private JFrame frame;
    private Screen screen;

    /**
     * @param width  of screen
     * @param scale  scale of screen
     * @param name   of appilcation
     * @param locked can change size or not
     */
    protected Graphics(int width, int scale, String name, boolean locked) {
        this.NAME = name;
        this.WIDTH = width;
        this.locked = locked;
        this.HEIGHT = width / 12 * 9;
        this.SCALE = scale;

        preInit();
    }

    private void preInit() {
        screen = new Screen(WIDTH, HEIGHT);

        init();
    }

    private void init() {
        frame = new JFrame(NAME);
        if (locked) {
            setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
            setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
            setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        } else {
            setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        if (locked)
            frame.setResizable(false);
        else
            frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        postInit();
        tick();
    }

    private void postInit() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();

    }

    protected void tick() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getSCALE() {
        return SCALE;
    }

    public String getNAME() {
        return NAME;
    }

    public boolean isLocked() {
        return locked;
    }

    public java.awt.Graphics getGraphics() {
        return graphics;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public JFrame getFrame() {
        return frame;
    }

    protected Screen getScreen() {
        return screen;
    }
}
