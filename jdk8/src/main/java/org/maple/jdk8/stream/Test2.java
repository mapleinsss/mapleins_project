package org.maple.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @Author Mapleins
 * @Date 2019-04-05 12:48
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {

        IntStream.of(new int[]{5,6,7,8}).forEach(System.out::print);

        System.out.println();

        IntStream.range(1,9).forEach(System.out::print); //含头不含尾

        System.out.println();

        IntStream.rangeClosed(1,9).forEach(System.out::print); //含头含尾

    }
}
