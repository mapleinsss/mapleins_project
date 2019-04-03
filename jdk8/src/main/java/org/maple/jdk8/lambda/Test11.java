package org.maple.jdk8.lambda;

import java.util.function.Supplier;

/**
 * @Author Mapleins
 * @Date 2019-04-03 23:09
 * @Description Supplier<T>
 */
public class Test11 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "hello world!";
        System.out.println(supplier.get());

        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get().getName());

        Supplier<Student> studentSupplier1 = Student::new;
        System.out.println(studentSupplier1.get().getName());

    }
}
