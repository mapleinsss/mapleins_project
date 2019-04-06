package org.maple.jdk8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-06 2:09
 * @Description
 */
public class Test7 {

    public static void main(String[] args) {

        // 将集合中的元素转换成大写，然后输出
        Stream<String> stream = Stream.of("hello ", "world ", "hello world", "test");
        stream.map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("---------------------------------");

        // 求出集合中每个数字的平方，打印
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.map(x -> x * x).collect(Collectors.toList()).forEach(System.out::println);



    }
}
