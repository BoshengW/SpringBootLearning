package org.depinject.cars;

import org.depinject.interfaces.Car;
import org.depinject.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Corlola implements Car {
    @Autowired
    @Qualifier("EngineType")
    Engine engine;


    @Override
    public void print() {
        System.out.println("This is Corlola" + engine.type());
    }
}
