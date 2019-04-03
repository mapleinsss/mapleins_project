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
     
## Lambda 表达式概要
     Java Lambda 表达式是一种匿名函数；它是没有声明的方法，即；没有访问修饰符、返回值声明、名字

## 接口
     java8 以前
        接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
        接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private 修饰会报编译错误）。
        接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。
     java8 
        可以定义 static 和 default 的方法

## public interface Consumer<T> 
     * Represents an operation that accepts a single input argument and returns no
     * result. Unlike most other functional interfaces, {@code Consumer} is expected
     * to operate via side-effects.
     负作用：理解为对数据的处理，接受一个参数不返回结果
     
## public interface Function<T, R> 
        R apply(T t);
     Represents a function that accepts one argument and produces a result.
     输入一个参数，返回一个结果
     
## public interface BiFunction<T, U, R> 
        R apply(T t, U u);
         * Represents a function that accepts two arguments and produces a result.
         * This is the two-arity specialization of {@link Function}.
        输入两个参数，返回一个结果
        
## public interface Comparator<T> 
       int compare(T o1, T o2);
       比较
    
## public interface Predicate<T> 
        boolean test(T t);
        and
        or
        negeat 取反
        Represents a predicate (boolean-valued function) of one argument.
        输入一个参数，返回布尔值

## public interface Supplier<T> 
        T get();
        There is no requirement that a new or distinct result be returned each time the supplier is invoked.
        不输出参数，返回结果
    __