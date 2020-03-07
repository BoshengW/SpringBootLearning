package org.depinject.cars;


import org.depinject.interfaces.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Benz implements Car {

//    // without @Autowired if you not create new instance it will show NullPointerError
//    Engine engine = new Engine(); // this is dependency class which is not good, need IOC

    // Spring IOC way -> @Autowird
    @Autowired // when it's not required to save into memory -> use required
    Engine engine;

    // need to make sure bean has an empty constructor
    // how if we want to update some values into this object

//    //1. setter injection
//    public void setEngine(Engine engine) {
//        engine.type = "New V8.1";
//        this.engine = engine;
//    }

//    //2. constructor injection
////    @Autowired
//    public Benz(Engine engine) {
//        engine.type = "New V8.2";
//        this.engine = engine;
//
//    }

    @Override
    public void print() {
        String specs = "This is Benz " + engine.type;
        System.out.println(specs);
    }
}
