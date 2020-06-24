/**  
* Title: HelloService.java  
* Description: 
* @author：wh
* @date 2019年8月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.cglib;

/**
 *@class_name：HelloService
 *@comments:cglib代理被代理类
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年8月7日
 */
public class HelloService {
	 
    public HelloService() {
        System.out.println("HelloService构造");
    }
 
    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }
 
    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}

