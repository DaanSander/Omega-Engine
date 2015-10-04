package com.daansander.engine;

import com.daansander.engine.graphics.Render;
import com.daansander.engine.graphics.RenderType;

/**
 * @author Daan Meijer
 * @since 0.1
 */
public abstract class Engine extends Render {

    public Engine() {
        super(false, "Test", 300, RenderType.NANOSECOND, 2);
    }

    @Override
    public abstract void update();
}
