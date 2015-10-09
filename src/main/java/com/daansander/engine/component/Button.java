package com.daansander.engine.component;

import java.util.HashSet;

/**
 * Created by Daan on 8-10-2015.
 */
public abstract class Button implements Component {

    protected HashSet<ListenerComponent> listenerComponents = new HashSet<>();
}
