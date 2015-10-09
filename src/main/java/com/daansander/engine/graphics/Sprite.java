package com.daansander.engine.graphics;

import com.daansander.engine.component.Component;
import com.daansander.engine.math.Vector2D;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daan on 17-9-2015.
 */
public class Sprite implements Component {

    public String path;
    public int width;
    public int height;

    public Vector2D vector;

    public int[] pixels;

    public Sprite(String path, Vector2D vector) {
        this.vector = vector;
        this.path = path;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image == null) return;
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = image.getRGB(0, 0, width, height, null, 0, width);
    }

    @Override
    public void render() {
        //TODO: Render sprite
    }
}
