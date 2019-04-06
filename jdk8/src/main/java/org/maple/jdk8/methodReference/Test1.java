package org.maple.jdk8.methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:23
 * @Description
 */
public class Test1 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world!");
//        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

    }
}
