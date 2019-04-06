package org.maple.jdk8.interfacem;

/**
 * @Author Mapleins
 * @Date 2019-04-05 1:18
 * @Description
 */
//如果实现了两个接口，并且有相同名的默认方法，编译器会报错
public class MyClass implements MyInterface1,MyInterface2 {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    //解决办法1，重写方法
//    @Override
//    public void myMethod() {
//        System.out.println("MyClass");
//    }

    //解决办法二，想用其中一个接口的默认方法
    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }
}
