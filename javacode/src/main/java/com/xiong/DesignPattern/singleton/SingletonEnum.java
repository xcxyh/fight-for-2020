package com.xiong.DesignPattern.singleton;
/**
 *  @author: xiongcong
 *  @Date: 2020/1/14 16:08
 *  @Description:  使用枚举构造单例类  线程安全 预防 反射攻击和 序列化攻击等
 */
public enum SingletonEnum {
    SINGLETON_ENUM;

    public static SingletonEnum getInstance(){
        return SINGLETON_ENUM;
    }
}
