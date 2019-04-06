package org.maple.jdk8.methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:48
 * @Description 引用名(对象名)::实例方法名
 */
public class Test3 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        StudentComparator comparator = new StudentComparator();

//        list.sort((x, y) -> comparator.compareStudentByScore(x, y));
//        list.forEach(System.out::println);

        //引用::实例方法
        list.sort(comparator::compareStudentByScore);
        list.forEach(System.out::println);
    }
}
