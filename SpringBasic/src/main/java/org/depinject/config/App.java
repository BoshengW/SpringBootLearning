package org.depinject.config;

import org.depinject.cars.Benz;
import org.depinject.cars.Toyota;
import org.depinject.interfaces.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

//        // traditional design
//        Car benz = new Benz();
//        Car toyota = new Toyota();
//
//        benz.print();
//        toyota.print();

        // use java bean
        // use this to get beans we need a java object for configuration
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class); // read configuration file

        // 多态性 ?
        // 在applicationContext getbean时如果有多个bean 需要在@Component中进行注释
        Car myCar = applicationContext.getBean("Corlola",Car.class); // get the bean-> based on implementation
        myCar.print();
        applicationContext.close();

    }
}
