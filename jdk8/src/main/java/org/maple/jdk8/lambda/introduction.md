# Lambda 表达式
## 为什么需要 Lambda 表达式
    在java中，我们无法将函数作为参数传递给一个法法，也无法声明返回一个函数的方法。

## @FunctionalInterface
    函数式接口：
     * <p>Note that instances of functional interfaces can be created with
     * lambda expressions, method references, or constructor references.
        ()-{}            System.out::println()   
     1.如果一个接口只有一个抽象方法，那么该接口就是函数式接口
     2.如果我们在某个接口上声明了 @FunctionalInterface 注解，编译器就会按照函数式接口定义来要求该接口。
     3.如果某个接口只有一个抽象方法，我们没有给该接口声明 @FunctionalInterface,编译器仍然会给该接口看做函数式接口
     4.如果某个接口声明了一个抽象方法，该抽象方法重写了 Object 类的方法，不会给该接口的抽象方法+1
     5.Lambda 表达式是对象，他们必须依附于函数式接口
