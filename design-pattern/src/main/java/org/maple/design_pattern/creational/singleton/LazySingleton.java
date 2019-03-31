package org.maple.design_pattern.creational.singleton;

/**
 * @author mapleins
 * @Date 2019-03-15 10:23
 * @Desc 懒汉式
 **/
public class LazySingleton {

    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
    private static LazySingleton instance;

    private LazySingleton(){ //私有化构造器
    }

    //方法同步，调用效率低！
    public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
