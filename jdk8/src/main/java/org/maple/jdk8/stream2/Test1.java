package org.maple.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Mapleins
 * @Date 2019-04-07 23:20
 * @Description p=22
 */
public class Test1 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan",80);
        Student s2 = new Student("lisi",90);
        Student s3 = new Student("wangwu", 100);
        Student s4 = new Student("zhaoliu", 90);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        List<Student> list2 = list.stream().collect(Collectors.toList());
        list2.forEach(System.out::println);





    }
}
