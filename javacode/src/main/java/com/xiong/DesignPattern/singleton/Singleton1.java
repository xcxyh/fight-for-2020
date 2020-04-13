package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 16:32
 * @description： 饿汉式  天然线程安全
 * 饿汉式 1
 * @modified By：
 * @version: $
 */
public class Singleton1 {
    //必须加 final  不然 会被修改
    public static final Singleton1 INSTANCE = new Singleton1();
    //私有 构造器
    private Singleton1() {

    }

}
