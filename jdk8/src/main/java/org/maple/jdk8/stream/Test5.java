package org.maple.jdk8.stream;

import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-06 1:47
 * @Description 演示流转字符串拼接
 */
public class Test5 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", " world", " !");

//        StringBuilder sb = stream.collect(() -> new StringBuilder(), (x, y) -> x.append(y), (sb1, sb2) -> sb1.append(sb2));

        StringBuilder sb = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(sb);


    }
}
