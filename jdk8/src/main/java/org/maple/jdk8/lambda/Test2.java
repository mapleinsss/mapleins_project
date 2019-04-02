package org.maple.jdk8.lambda;

@FunctionalInterface
interface MyInterface{
    void test();
    String toString();
}

public class Test2 {

    public static void myTest(MyInterface myInterface){
        System.out.println("step one ");
        myInterface.test();
        System.out.println("step two ");
    }

    public static void main(String[] args) {
        //1
//        myTest( () -> System.out.println("test 1.5") );
        //2
        MyInterface myInterface = () -> System.out.println("step 1.5");
        System.out.println(myInterface.getClass()); //class org.maple.jdk8.lambda.Test2$$Lambda$1/1324119927 可以看出 lambda 表达式是一个对象
        System.out.println(myInterface.getClass().getSuperclass()); //class java.lang.Object
        myTest(myInterface);
    }

}
