package org.depinject.cars;
import org.depinject.interfaces.Car;
import org.depinject.interfaces.Engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Toyota") //when same interface has multiple impl classes then you need to add name to identify them
public class Toyota implements Car {

//    @Autowired
//    Engine v6; // Spring can compare name with name of class if exist they will autowired that variable but this is not good way.

    // better way to specify which exact bean needs to be wired
    // 在bean里面调用其他dependency bean class. 你可以用@Qualifier(<bean name>)去选择你需要那个
    @Autowired
    @Qualifier("V6Engine") // use this input to choose the bean you need
    Engine engine;

    @Override
    public void print() {
        System.out.println("This is Toyota"+engine.type());
    }
}
