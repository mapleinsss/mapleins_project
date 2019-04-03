package org.maple.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mapleins
 * @create 2019-04-03 9:47
 * @description comparator
 */
public class Test5 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
        //1
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        System.out.println(list);

        //2
//        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);

        //3
        /**
         * @FunctionalInterface
         * public interface Comparator<T> {
         *      int compare(T o1, T o2);
         * }
         */
        list.sort((o1,o2) -> o2.compareTo(o1));
        System.out.println(list);

    }
}
