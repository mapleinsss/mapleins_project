package org.maple.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @Author Mapleins
 * @Date 2019-04-07 0:34
 * @Description
 */
public class Test9 {

    public static void main(String[] args) {

        // 找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉流中的前两个元素，然后再获取流中的两个元素，最后求出流中元素的总和
        Stream<Integer> stream = Stream.iterate(1, x -> x + 2).limit(6);
        // 我的写法
//        stream.filter(x -> x > 2).map(x -> x * 2).skip(2).limit(2).reduce((x, y) -> x + y).ifPresent(System.out::println);

        // 使用 mapToInt 可以避免 Function<T,R> 中将数字自动装箱成 Integer类型，避免了性能的损耗
//        int sum = stream.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(2).sum();
//        System.out.println(sum);

//        stream.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(0).min().ifPresent(System.out::println);
//        stream.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(2).max().ifPresent(System.out::println);
//        System.out.println(max);

        /**
         * sum() 如果没有存在的返回 0
         * min() max() 如果没有 则返回 empty Optional
         */

        IntSummaryStatistics intSummaryStatistics = stream.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(2).summaryStatistics();
        if(intSummaryStatistics.getCount()>0){
            System.out.println(intSummaryStatistics.getMax());
            System.out.println(intSummaryStatistics.getMin());
            System.out.println(intSummaryStatistics.getAverage());
            System.out.println(intSummaryStatistics.getSum());
        }

    }
}
