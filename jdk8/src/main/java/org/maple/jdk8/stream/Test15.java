package org.maple.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Mapleins
 * @Date 2019-04-07 12:20
 * @Description groupingBy   counting()  averagingDouble  partitioningBy
 */
public class Test15 {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 18, 80);
        Student s2 = new Student("lisi", 22, 60);
        Student s3 = new Student("wangwu", 11, 20);
        Student s4 = new Student("zhangsan", 44, 60);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        //group by
        //要求以 Map<String,List<Student>> 输出
//        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
//        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getScore));
//        System.out.println(map);

        //group by  count(1)
//        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
//        System.out.println(map);

        //avg
//        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
//        System.out.println(map);

        //分区 partitionBy ：只有 true 和 false
        Map<Boolean, List<Student>> map = list.stream().collect(Collectors.partitioningBy(x -> x.getScore() > 60));
        System.out.println(map);


    }
}
