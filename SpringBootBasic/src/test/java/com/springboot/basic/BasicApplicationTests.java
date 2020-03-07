package com.springboot.basic;

import com.springboot.basic.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.ApplicationContext;


// Spring 单元测试
@RunWith(SpringRunner.class)
@SpringBootTest
class BasicApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc; // 加载Spring IOC 容器+

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println(person.getDog().getName());
    }

}
