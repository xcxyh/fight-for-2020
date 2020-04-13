package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 16:36
 * @description：  饿汉式 3  静态代码块 实现 ，方便进行一些复杂的初始化操作
 * @modified By：
 * @version: $
 */
public class Singleton3 {
    //必须加 final  不然 会被修改
    public static final Singleton3 INSTANCE;
    static{
        //这里可以有一些复杂的初始化操作

        INSTANCE = new Singleton3();
    }
    //私有 构造器
    private Singleton3(){

    }

}
