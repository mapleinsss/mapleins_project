package org.maple.jdk8.interfacem;

/**
 * @Author Mapleins
 * @Date 2019-04-05 1:24
 * @Description
 */
//情况2：实现了一个接口有 myMethod(),继承了一个类，该类实现的父接口有 myMethod() ,此时编译器不会报错
public class MyClass2 extends MyInterface1Impl implements MyInterface1 {

    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.myMethod(); //MyInterface1
        //可以看出 取的是实现类的 myMethod() 方法
    }

}
