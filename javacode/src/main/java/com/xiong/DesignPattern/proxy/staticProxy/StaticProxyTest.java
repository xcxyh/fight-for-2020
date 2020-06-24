/**  
* Title: StaticProxyTest.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.staticProxy;

/**
 *@class_name： StaticProxyTest
 *@comments:  静态代理（代理对象和被代理对象同时实现一个方法，在代理对象调用方法时调用被代理对象的方法）
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理的学生张三，他的班费上交有代理对象monitor（班长）完成
        Person zhangsan = new Student("张三");
        //生成代理对象，并将张三传给代理对象(hiberate的延迟加载就使用了代理模式，先使用代理对象去代替被代理对象，等到对象真正要加载的时候才在代理对象中调用被代理对象的方法)
        Person monitor = new StudentsProxy(zhangsan);
        //班长代理上交班费
        monitor.giveMoney();
    }
}
