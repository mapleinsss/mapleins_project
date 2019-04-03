package org.maple.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Mapleins
 * @create 2019-04-03 21:59
 * @description Predicate
 */
public class Test10 {

    public static void main(String[] args) {
        // test()
//        Predicate<String> predicate = x -> x.length() > 5;
//        System.out.println(predicate.test("abcd"));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //找到集合中所有的奇数
        conditionFilter(list, x -> x % 2 == 1);
        System.out.println();
        //找到集合中所有的偶数
        conditionFilter(list, x -> x % 2 == 0);
        System.out.println();
        //找到集合中大于3的数
        conditionFilter(list, x -> x > 3);
        System.out.println();
        //打印出集合中所有的数
        conditionFilter(list, x -> true);
        System.out.println();

        //找出集合大于5 并且是偶数的数字
        conditionFilter2(list, x -> x > 5, x -> x % 2 == 0);
        System.out.println();

    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(x -> {
            if (predicate.test(x)) {
                System.out.print(x + " ");
            }
        });
    }

    public static void conditionFilter2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(x -> {
            if (predicate1.and(predicate2).test(x)) {
                System.out.print(x + " ");
            }
        });
    }
}
