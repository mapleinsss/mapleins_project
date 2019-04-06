package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-05 12:51
 * @Description
 */
public class Test3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        //  T reduce(T identity, BinaryOperator<T> accumulator);
        //  identity 初始值  这里的 BinaryOperator 的两个值分别是： 0 ,2  -> 2,4 -> 6,6 -> 12,8 -> 20,10 -> 32,12 -> 42
        Integer reduce = list.stream().map(x -> 2 * x).reduce(0, Integer::sum);

        System.out.println(reduce);
    }
}
