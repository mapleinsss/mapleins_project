package org.maple.jdk8.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author Mapleins
 * @Date 2019-04-05 1:10
 * @Description 类名::new
 */
public class Test5 {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + " !!!";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        System.out.println(test5.getString(String::new));

        System.out.println(test5.getString2("hello",String::new));
    }
}
