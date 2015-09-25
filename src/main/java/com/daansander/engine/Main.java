package com.daansander.engine;

/**
 * Created by Daan on 17-9-2015.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(new Render(false, "Test", 100)).start();
    }
}
