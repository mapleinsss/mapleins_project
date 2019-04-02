package org.maple.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mapleins
 * @create 2019-04-02 23:20
 * @description java中 lambda 表达式是对象，他们必须依附于函数式接口
 */
public class Test3 {

    public static void main(String[] args) {

        MyInterface1 my1 = () -> {
        };
        System.out.println(my1.getClass().getInterfaces()[0]); //实现的接口

        MyInterface2 my2 = () -> {
        };
        System.out.println(my2.getClass().getInterfaces()[0]); //实现的接口

        //可以看出 两个 lambda 表达式都是 ()->{},所以需要上下文来推断；

        //启动一个线程
//        new Thread( () -> System.out.println("start task") ).start();

        //把一个集合的字符串转换为大写，然后输出
        List<String> list = Arrays.asList("hello", "world", "hello world");
        List<String> listUpper = new ArrayList<>();
        //1
//        list.forEach( str -> listUpper.add(str.toUpperCase()));
//        listUpper.forEach( x-> System.out.println(x));
        //2 使用流，流类似管道符
//        list.stream().map( str -> str.toUpperCase() ).forEach( str -> System.out.print(str + " "));
        //3 方法引用
        list.stream().map(String::toUpperCase).forEach(str -> System.out.print(str + " "));
    }
}

@FunctionalInterface
interface MyInterface1 {
    void myMethod1();
}

@FunctionalInterface
interface MyInterface2 {
    void myMethod2();
}