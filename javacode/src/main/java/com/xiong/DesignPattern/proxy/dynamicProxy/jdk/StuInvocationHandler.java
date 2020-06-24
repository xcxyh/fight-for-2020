/**  
* Title: StuInvocationHandler.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *@class_name：StuInvocationHandler
 *@comments:代理类
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
public class StuInvocationHandler<T> implements InvocationHandler {
	   //invocationHandler持有的被代理对象
	    T target;
	    
	    public StuInvocationHandler(T target) {
	       this.target = target;
	    }
	    
	    /**
	     * DesignPattern.proxy:代表动态代理对象
	     * method：代表正在执行的方法
	     * args：代表调用目标方法时传入的实参
	     */
	    
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	        System.out.println("代理执行" +method.getName() + "方法");
	        //代理过程中插入监测方法,计算该方法耗时
	        MonitorUtil.start();
	        Object result = method.invoke(target, args);
	        MonitorUtil.finish(method.getName());
	        return result;
	    }
	}
