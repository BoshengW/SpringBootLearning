package org.depinject.config;

import org.depinject.cars.Benz;
import org.depinject.cars.Corlola;
import org.depinject.engine.EngineType;
import org.depinject.interfaces.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // @Bean only used in Configuration class
// why use @Bean -> used for converting third-party object as a bean -> since you cannot use @Component to convert it
@ComponentScan("org.depinject")
public class AppConfig {

    // configurate all your bean inside this class will be better.
    // except using @Component to define bean object, you can also use @Bean
    @Bean("benz")
    public Benz benz() {
        return new Benz();
    }

    @Bean("EngineType")
    public EngineType engineType() {

        return new EngineType(); // 如果我enginetype 有两个constructor那么我们如何注入???
    }

    @Bean("Corlola")
    public Corlola corlola(){
        return new Corlola();
    }




}
