package org.maple.jdk8.lambda;

import java.util.function.Function;

/**
 * @author Mapleins
 * @create 2019-04-03 20:30
 * @description Function<T , R>
 */
public class Test6 {

    public static void main(String[] args) {
        /**
         * 这个例子充分可以看出，面向对象和函数式编程的区别
         * 面向对象需要先把行为定义好，传递参数调用行为，就可以实现想要的结果
         * 而函数式编程，是把行为作为参数传进去，用户可以自定义自己的行为，而不是事先定义好的。
         */
        System.out.println(compute(1, x -> x * 2));
        System.out.println(multiply2(1));
        System.out.println(compute(1, x -> x + 2));
        System.out.println(add(1));

        System.out.println(convert(1, x -> "输入的值是：" + x));
    }

    public static int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public static String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public static int add(int a) {
        return a + 2;
    }

    public static int multiply2(int a){
        return a * 2;
    }

}
