package org.depinject.engine;

import org.depinject.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("V6Engine")
public class V6 implements Engine {
    @Override
    public String type() {
        return "V6 Engine";
    }
}
