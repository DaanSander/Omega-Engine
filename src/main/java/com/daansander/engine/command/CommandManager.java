package com.daansander.engine.command;

import java.util.HashSet;

/**
 * Created by Daan on 25-9-2015.
 */
public class CommandManager implements Runnable {

    protected HashSet<Object> cmds = new HashSet<Object>();

    protected CommandManager() {
        new Thread(this, "Command").start();
    }

    public void run() {

    }
}
