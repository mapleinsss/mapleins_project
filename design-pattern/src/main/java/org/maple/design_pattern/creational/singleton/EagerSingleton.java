package org.maple.design_pattern.creational.singleton;

/**
 * @author mapleins
 * @Date 2019-03-15 10:21
 * @Desc 恶汉式
 **/
public class EagerSingleton {
    //类初始，立即加载对象，天然线程安全
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){}
    //方法没有同步，调用效率高
    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }
}
