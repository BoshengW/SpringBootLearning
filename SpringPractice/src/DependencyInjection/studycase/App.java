package DependencyInjection.studycase;

import DependencyInjection.Interface.Car;
import DependencyInjection.cars.Toyota;
import DependencyInjection.cars.Benz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        Car Benz = new Benz();
        Car Toyota = new Toyota();

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car myCar = context.getBean(Car.class);

        myCar.print();
        context.close();


    }
}
