package org.maple.jdk8.methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:30
 * @Description 类名::方法名
 */
public class Test2 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        // 使用 Collection.sort(list,comparator) lambda 表达式排序
        Collections.sort(list, (x, y) -> x.getScore().compareTo(y.getScore()));
        System.out.println(list);

        // 使用 list.sort 排序
        list.sort((x, y) -> x.getScore() - y.getScore());
        System.out.println(list);

        // 使用方法引用 类名::静态方法
        /**
         * 方法引用是不需要参数的，参数是自动推断的，是指向的
         * 而 类名.静态方法，是需要参数的，是方法调用
         */
        list.sort(Student::compareStudentByScore);
        list.forEach(System.out::println);

    }

}
