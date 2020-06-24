package com.xiong.AForkTheWork.CompanyZHAOYIN;

import com.xiong.DesignPattern.proxy.dynamicProxy.jdk.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/22 20:05
 * @description：  jdk 版本的 动态代理的编写
 * @modified By：
 * @version: $
 */
public class ZY2_ProxyDemo {

    Person target;
    //是个填空题
    // 关于一些动态代理的
    Person stuProxy = (Person) Proxy.newProxyInstance(
            Person.class.getClassLoader(), //和目标对象的类加载器保持一致
            Person.class.getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(target, args);
                }
            });//InvocationHandler:事件处理器，即对目标对象方法的执行



    //还有一些 关于注解的 例如
    // @Target({ElementType.METHOD})
}
