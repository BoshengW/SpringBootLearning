package com.springboot.basic.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

// 将配置文件yml中每一个组件的值映射到这个类组件中
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:person.properties"})
public class Person {
    /*
    * <bean class="Person">
    *   <property name="lastName" value="字符串/${key}从环境变量，配置文件中获取值/#{Spel}"></property>
    * <bean/>
    * */

    //从配置文件中获取值

//    @Value("${person.last-name}")

//    @Email // must be email format
// add data validation-> last name 是邮箱格式
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
    private Boolean boss;
    private Date birth;


    private Dog dog;
    private List<Object> lists;
    private Map<String,Object> maps;

    @Override
    public String toString() {
        return "Person{" +
                "lastname" + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
}
