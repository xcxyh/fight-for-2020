package com.xiong.DesignPattern.singleton;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 16:42
 * @description： 懒汉式 3    使用静态内部类  线程安全
 * 静态内部类不会随着外部类的加载和初始化而 初始化
 * 在内部类 创建和初始化时， 创建实例对象
 * @modified By：
 * @version: $
 */
public class Singleton6 {

    // 私有 静态内部类
    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    //私有 构造器
    private Singleton6() {
    }

    //对外提供静态方法 访问
    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }

}
