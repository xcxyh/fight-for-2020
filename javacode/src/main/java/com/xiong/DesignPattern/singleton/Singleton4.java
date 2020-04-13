package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 16:38
 * @description： 懒汉式1  线程不安全
 * @modified By：
 * @version: $
 */
public class Singleton4 {

    private static Singleton4 instance;
    //私有 构造器
    private Singleton4(){

    }
    //对外提供静态方法 访问
    public static Singleton4 getInstance(){
        if (instance == null){  //线程不安全
            instance = new Singleton4();
        }
        return instance;
    }
}
