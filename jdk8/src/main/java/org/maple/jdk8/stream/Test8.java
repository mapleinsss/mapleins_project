package org.maple.jdk8.stream;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-06 23:50
 * @Description
 */
public class Test8 {

    public static void main(String[] args) {
        // stream.generate ( supplier)
        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
        // stream.findFirst() 找到流中第一个元素
        stringStream.findFirst().ifPresent(System.out::println);

        // stream.iterator
        /**
         * Stream<T> iterate(final T seed, final UnaryOperator<T> f)
         * Returns an infinite sequential ordered {@code Stream} produced by iterative
         * 通过迭代 返回一个无限大 串行 有序的结果
         * UnaryOperator: 一元操作：
         *      static <T> UnaryOperator<T> identity() {
         *         return t -> t;
         *     }
         * 需要配合 limit 使用，否则无限的重复操作
         */
        Stream.iterate(1, x -> x + 2).limit(5).forEach(System.out::println);

    }
}
