package org.maple.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Mapleins
 * @create 2019-04-02 22:43
 * @description
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //1
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.print(integer+" ");
//            }
//        });
        //2
//        list.forEach( i -> System.out.print(i+ " "));
        //3
        list.forEach(System.out::println); // 方法引用创建函数式接口 method reference
    }
}
