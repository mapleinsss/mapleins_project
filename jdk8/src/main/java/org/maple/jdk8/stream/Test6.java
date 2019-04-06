package org.maple.jdk8.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-06 1:58
 * @Description
 */
public class Test6 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello ", "world ", "hello world");

        //由于 Collectors.toList() 只能转换成 ArrayList, 所以提供了一个可以选择的方法
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        List<String> list = stream.collect(Collectors.toCollection(LinkedList::new));
//        System.out.println(list);

        //还可以转换成 set
//        TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(set);

        //字符串拼接 除了之前的 collect() 方法的 stirngBuilder 来构造，还可以使用 Collectors.joining 按照遇到的顺序进行拼接
        String str = stream.collect(Collectors.joining());
        System.out.println(str);


    }
}
