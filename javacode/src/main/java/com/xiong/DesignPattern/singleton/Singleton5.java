package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/14 15:59
 * @description： 懒汉式 2   线程安全
 * <p>
 * 双重检查线程安全单例类
 * @modified By：
 * @version: $
 */
public class Singleton5 {

    private static volatile Singleton5 instance; //volatile 保证可见性 和禁止指令重排
    //私有 构造器
    private Singleton5() {
    }

    //对外提供静态方法 访问
    public static Singleton5 getInstance() {
        if (instance == null) { //这个检查可以提高性能
            synchronized (Singleton5.class) { //锁为类对象
                if (instance == null) { //这个检查保证 单例
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
