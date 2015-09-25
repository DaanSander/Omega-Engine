package com.daansander.engine;

/**
 * Created by Daan on 25-9-2015.
 */
public abstract class Engine {

    public Engine() {
        new Thread(new Render(false, "Test", 100)).start();
    }
}
