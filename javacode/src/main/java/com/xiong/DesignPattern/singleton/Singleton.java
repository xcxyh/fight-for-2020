package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/14 15:59
 * @description： 双重检查线程安全单例类
 * @modified By：
 * @version: $
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { //锁为类对象
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
