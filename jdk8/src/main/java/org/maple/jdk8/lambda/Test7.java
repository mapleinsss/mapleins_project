package org.maple.jdk8.lambda;

import java.util.function.Function;

/**
 * @author Mapleins
 * @create 2019-04-03 20:49
 * @description Function<T , R> compose 和 andThen
 */
public class Test7 {

    public static void main(String[] args) {
        System.out.println(compute1(2, x -> x * 3, x -> x * x)); // 12
        System.out.println(compute2(2, x -> x * 3, x -> x * x)); // 36
    }

    /**
     * compose 是调用者在参数的行为后执行
     */
    public static int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    /**
     * andThen 是调用者在参数的行为之前执行
     */
    public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

}
