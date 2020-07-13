package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/4 8:13
 * @description：  双重检查线程安全单例类
 * @modified By：
 * @version: $
 */
public class Singleton{
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){

        if (instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
