package com.daansander.engine;

import com.daansander.engine.graphics.Render;
import com.daansander.engine.graphics.RenderType;

/**
 * @author Daan Meijer
 * @since 0.1
 */
public abstract class Engine extends Render {

    public Engine() {
        super(false, "Test", 100, RenderType.MILISECOND, 2);
    }

    @Override
    public abstract void update();
}
