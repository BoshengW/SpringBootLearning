package org.depinject.engine;

import org.depinject.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("V8Engine")
public class V8 implements Engine {
    @Override
    public String type() {
        return "V8 Engine";
    }
}
