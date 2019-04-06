package org.maple.jdk8.interfacem;

/**
 * @Author Mapleins
 * @Date 2019-04-05 1:18
 * @Description
 */
public interface MyInterface1 {

    default void myMethod(){
        System.out.println("MyInterface1");
    }
}
