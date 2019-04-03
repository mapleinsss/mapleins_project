package org.maple.jdk8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Mapleins
 * @create 2019-04-03 21:00
 * @description BiFunction<T , U ,   R> 可以实现传入两个参数，输出一个结果
 */
public class Test8 {

    public static void main(String[] args) {

        System.out.println(add(1, 1, (x, y) -> x + y)); //2

        System.out.println(addAndDiv(1, 1, (x, y) -> x + y, z -> z * z)); //4
    }

    public static int add(int a, int b, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(a, b);
    }

    /**
     * BiFunction 只有 andThen ，因为如果有 compose 的话，先调用 compose 就会得到一个值，这个值就不能做为后面的 BiFunction.apply()使用了，因为 BiFunction 需要两个参数
     * 而使用 andThen,先调用 BiFunction 返回一个结果，然后就可以用这个结果进行 apply() 了。
     */
    public static int addAndDiv(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
