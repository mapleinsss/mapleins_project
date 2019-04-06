package org.maple.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-06 2:09
 * @Description flatMap
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

        System.out.println("---------------------------------");

        /**
         * flatmap: 如果是一个 arraylist -> 那么进入 map 映射就是 值 -> 值
         *          如果是多个 arraylist -> 那么进去 map 映射后 依然是 一个 list 值 ->值
         *          而使用 flatmap 映射 则是把所有 arraylist 中的值 -> 映射为一个集合中的值
         */
        // 将 ArrayList 中的每个元素平方，之后作为一个整体输出
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5));
        // 把集合变成流，然后映射为一个整体集合
        listStream.flatMap(Collection::stream).map(x -> x * x).collect(Collectors.toList()).forEach(System.out::println);



    }
}
