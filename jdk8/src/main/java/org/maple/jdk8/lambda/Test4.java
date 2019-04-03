package org.maple.jdk8.lambda;

import java.util.function.Function;

/**
 * @author Mapleins
 * @create 2019-04-03 9:39
 * @description
 */
public class Test4 {

    public static void main(String[] args) {
        /**
         * 此处可以看出 该方法声明调用的是 Function 接口
         * 输入 T 必定是输入的字符串，虽然没有传入
         * 而输出则是 String 类型 对应后面的 Function<T,R> 中的 R
         * public String toUpperCase() {
         * return toUpperCase(Locale.getDefault());
         * 总结：如果是通过 类::实例方法 ，那么对应的 Lambda 表达式的第一个对象就是调用这个方法的那个对象。
         */
        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);//interface java.util.function.Function


    }
}
