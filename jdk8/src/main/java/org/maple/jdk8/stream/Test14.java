package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Mapleins
 * @Date 2019-04-07 12:10
 * @Description
 */
public class Test14 {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("hi", "hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        /**
         * 要求输出 hi zhangsan hi lisi hi wangwu...
         */
        list1.stream().flatMap(x -> list2.stream().map(y -> x + " " + y)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
