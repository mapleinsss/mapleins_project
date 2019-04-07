package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-07 1:20
 * @Description
 */
public class Test10 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "hello world!", "world");

        // 把元素首字母转大写输出
        list.stream().map(x -> x.substring(0,1).toUpperCase() + x.substring(1)).forEach(System.out::println);



    }
}
