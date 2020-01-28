package DependencyInjection.cars;

import DependencyInjection.Interface.Car;
import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car {

    @Override
    public String print() {
        return "This is Toyota";
    }
}
