package com.xiong.AForkTheWork.CompanyByteDance;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 19:49
 * @description：  双重检查单例
 * @modified By：
 * @version: $
 */
public class DoubleCheckSingleton {
    //  volatile 作用
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){}


    public static DoubleCheckSingleton getInstance(){

        if(instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
