package org.maple.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-05 14:14
 * @Description 演示流转集合
 */
public class Test4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "world", "hello world");
        //将上面的流转换为字符数组
//        String[] arr = stream.toArray(length -> new String[length]);
        String[] arr = stream.toArray(String[]::new);
        Arrays.asList(arr).forEach(System.out::println);

        System.out.println("---------------------------------");

        // 将流转换为 list
        Stream<String> stream2 = Stream.of("hello", "world", "hello world");
        // api 方法 只能转换成 ArrayList
//        List<String> list = stream2.collect(Collectors.toList());
        /**
         * 上面的 collect()方法的原始实现如下
         *  collect((Supplier<A> supplier,               提供者：提供容器，来将流放入容器
         *           BiConsumer<A, T> accumulator,       消费者：传入两个参数，不返回值，这里的两个参数是：1.集合 2.流中的元素
         *           BinaryOperator<A> combiner,         合并者：Function：传入两个一样参数类型，返回一个结果，把流中产生的集合，加入到 new 出的 list 当中
         *           Set<Characteristics> characteristics)
         *
         */
//        List list = stream2.collect(() -> new ArrayList<>(), (list1, item) -> list1.add(item),(newList,list1) -> newList.addAll(list1) );
//        List list = stream2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List list = stream2.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list.forEach(System.out::println);


    }
}
