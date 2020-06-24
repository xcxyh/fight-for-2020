/**  
* Title: MonitorUtil.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.jdk;

/**
 *@class_name：MonitorUtil
 *@comments:
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
public class MonitorUtil {
    
    private static ThreadLocal<Long> tl = new ThreadLocal<Long>();
    
    public static void start() {
        tl.set(System.currentTimeMillis());
    }
    
    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
