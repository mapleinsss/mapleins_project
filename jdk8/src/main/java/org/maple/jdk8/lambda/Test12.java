package org.maple.jdk8.lambda;

import java.util.function.BinaryOperator;

/**
 * @Author Mapleins
 * @Date 2019-04-03 23:20
 * @Description BinaryOperator
 */
public class Test12 {

    public static void main(String[] args) {
        System.out.println(operate(1, 2, (x, y) -> x + y));
    }

    /**
     * binaryOperator 继承了 BiFunction,只是对两个同样类型的进行计算，简化了 BiFunction
     */
    public static int operate(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }


}
