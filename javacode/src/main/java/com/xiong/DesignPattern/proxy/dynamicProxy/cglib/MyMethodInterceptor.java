/**  
* Title: MyMethodInterceptor.java  
* Description: 
* @author：wh
* @date 2019年8月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.cglib;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
/**
 *@class_name：MyMethodInterceptor
 *@comments:代理类
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年8月7日
 */

 
/**
 * 自定义MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor{
 
    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }
}

