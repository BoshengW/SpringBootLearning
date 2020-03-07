package org.depinject.engine;

import org.depinject.interfaces.Engine;

public class EngineType implements Engine {
    String type;

    // make V8,V6 class into this more flexible class
    public EngineType() {
        this.type = "Unknown";
    }

    public EngineType(String type) {
        this.type = type;
    }

    @Override
    public String type() {
        return type;
    }
}
