package org.maple.jdk8.interfacem;

/**
 * @Author Mapleins
 * @Date 2019-04-05 1:20
 * @Description
 */
public interface MyInterface2 {

    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
