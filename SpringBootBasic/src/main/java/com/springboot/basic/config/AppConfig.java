package com.springboot.basic.config;

import com.springboot.basic.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean");
        return new HelloService();
    }
}
