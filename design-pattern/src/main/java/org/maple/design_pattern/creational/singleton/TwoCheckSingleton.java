package org.maple.design_pattern.creational.singleton;

/**
 * @author mapleins
 * @Date 2019-03-15 10:27
 * @Desc 双重检锁模式
 **/
public class TwoCheckSingleton {

    private static TwoCheckSingleton instance = null;

    private TwoCheckSingleton(){}

    /**
     * 第一个if,提高程序效率，相比懒汉式，如果已经拿到对象，就不会进同步方法。
     * 第二个if，保证单例
     */
    public static TwoCheckSingleton getInstance() {
        if (instance == null) {
            //1.线程A，线程B同时到达，A往下执行，B等待
            synchronized (instance) {
                //2.B进来，发现此时instance不为空，返回
                if (instance == null) {
                    instance = new TwoCheckSingleton(); //1.A执行完成拿到对象，返回
                }
            }
        }
        return instance;
    }

}
