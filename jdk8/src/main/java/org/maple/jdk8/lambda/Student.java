package org.maple.jdk8.lambda;

/**
 * @Author Mapleins
 * @Date 2019-04-03 23:15
 * @Description
 */
public class Student {

    private String name = "zhangsan";

    private Integer age = 23;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
