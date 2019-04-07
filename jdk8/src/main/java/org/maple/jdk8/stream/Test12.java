package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-07 11:41
 * @Description
 */
public class Test12 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");

        // 找出列表中长度为5的单词，打出长度

//        list.stream().filter( x -> x.length() == 5).limit(1).forEach(System.out::println); //wrong

//        list.stream().map(String::length).filter(x -> x == 5).limit(1).findFirst().ifPresent(System.out::println); //right

        // 思考打印结果，反思流的操作
        list.stream().mapToInt(item->{
            int result = item.length();
            System.out.println(item);
            return result;
        }).filter(x->x==5).limit(1).findFirst().ifPresent(System.out::println);


    }
}
