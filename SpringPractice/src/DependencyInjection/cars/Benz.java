package DependencyInjection.cars;

import DependencyInjection.Interface.Car;
import org.springframework.stereotype.Component;

@Component
public class Benz implements Car {

    @Override
    public String print() {
        return "This is Benz";
    }
}
