package org.maple.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Mapleins
 * @Date 2019-04-07 11:28
 * @Description 串行流和并行流 时间比较
 */
public class Test11 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(5000000);

        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("开始计时");

        long startTime = System.nanoTime();

        list.stream().sorted().count();        //3422
        list.parallelStream().sorted().count(); // 884

        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println("排序耗时：" + millis);


    }

}
