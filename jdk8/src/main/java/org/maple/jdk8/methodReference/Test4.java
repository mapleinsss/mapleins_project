package org.maple.jdk8.methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:57
 * @Description 类名::实例方法名
 */
public class Test4 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        list.sort(Student::compareByScore);
//        System.out.println(list);

        List<String> cities = Arrays.asList("beijing","shanghai","guangzhou","shengzheng","hangzhou");
//        Collections.sort(cities,(x,y) -> x.compareToIgnoreCase(y));
//        System.out.println(cities);
        Collections.sort(cities,String::compareToIgnoreCase);
        System.out.println(cities);
    }
}
