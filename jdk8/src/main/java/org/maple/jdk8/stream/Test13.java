package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Mapleins
 * @Date 2019-04-07 11:55
 * @Description
 */
public class Test13 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        // 找出所有单词，并且去重

        list.stream().map(x -> x.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
