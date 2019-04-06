package org.maple.jdk8.optional;

import org.maple.jdk8.lambda.Person;

import java.util.Optional;

/**
 * @Author Mapleins
 * @Date 2019-04-04 18:41
 * @Description
 */
public class Test1 {

    public static void main(String[] args) {

        // Optional.of(value)，value值不能为空，否则空指针
        // 确定不为空
        Optional<String> optional1 = Optional.of("hello");
        //一定为空
        Optional<String> optional = Optional.empty();
        //不确定是否是空
        Optional<String> str = Optional.ofNullable("str");

//        if(optional.isPresent()){ //不使用 isPresent()，会警告
//            System.out.println(optional.get());
//        }



        optional.ifPresent(x -> System.out.println(x)); //推荐 optional 的使用方式

        System.out.println(optional.orElse("world")); //为空打印其他值

        System.out.println(optional.orElseGet( () -> "你好"));

    }
}
