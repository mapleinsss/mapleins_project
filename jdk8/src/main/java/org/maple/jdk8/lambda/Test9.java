package org.maple.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Mapleins
 * @create 2019-04-03 21:36
 * @description
 */
public class Test9 {

    public static void main(String[] args) {

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        // 找到张三
        System.out.println(getPersonByUsername("zhangsan", persons));
        //找到年龄大于20的
        System.out.println(getPersonByAge(20, persons));
        //使用 BiFunction
        System.out.println(getPersonByAge2(20, persons, (x, y) ->
                y.stream().filter(person -> person.getAge() > x).collect(Collectors.toList())
        ));
    }

    public static List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(int age, List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }

}
