package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-05 12:43
 * @Description stream 的创建
 *
 *      1.stream.of(value/arr)
 *      2.Arrays.stream(arr)
 *      3.list.stream()
 */
public class Test1 {

    public static void main(String[] args) {

        /**
         * 创建流的三种方式
         */

        //1.通过 static stream.of(value)
        Stream s1 = Stream.of("hello","world","hello world");

        //2.通过 数组创建，和1没区别
        String [] arr = new String[]{"hello","world","hello world"};
        Stream s2 = Stream.of(arr);
        Stream<String> s3 = Arrays.stream(arr);

        //3.根据集合创建
        List<String> list = Arrays.asList(arr);
        Stream<String> s4 = list.stream();

    }
}
