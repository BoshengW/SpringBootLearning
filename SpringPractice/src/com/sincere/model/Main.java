package com.sincere.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// what spring can help us is to remove "new" when create a new object
public class Main {

    // without using
    @Autowired
    private AnotherUser anotherUser;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        // spring use singleton for design pattern
        User user1 = (User) applicationContext.getBean("user");
        // without add scope , two object should has same address
        System.out.println(user);
        System.out.println(user1);

        // add scope = "prototype", two object should has different address
        System.out.println(user);
        System.out.println(user1);

        // above two operation are same as below
        // User user = new User();


    }
}
