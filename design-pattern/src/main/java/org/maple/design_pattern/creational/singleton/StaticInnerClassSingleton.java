package org.maple.design_pattern.creational.singleton;


/**
 * @author mapleins
 * @Date 2019-03-15 10:46
 * @Desc 静态内部类实现单例
 **/
public class StaticInnerClassSingleton {

    public static class SingletonInstance{
        //静态内部类的静态属性，调用时加载，实现懒加载
        //没有同步代码块，调用效率高
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
        static {
            System.out.println("加载完成 => instance:"+instance);
        }
    }

    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return SingletonInstance.instance;
    }

//    public static void test(){
//        System.out.println("测试没调用获取实例的方法，是否加载了instance");
//    }
//
//    public static void main(String[] args) {
//        StaticInnerClassSingleton.test();
//        StaticInnerClassSingleton.getInstance();
//    }
}
