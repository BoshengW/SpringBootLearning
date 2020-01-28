package DependencyInjection.studycase;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // spring will initializa itself after this annotation
@ComponentScan("DependencyInjection") // tell spring scan which class
public class AppConfig {
}
