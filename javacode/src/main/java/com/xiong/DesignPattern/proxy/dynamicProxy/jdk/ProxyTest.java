/**  
* Title: ProxyTest.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *@class_name：ProxyTest
 *@comments: jdk动态代理测试类
 *我们创建了一个需要被代理的学生张三，将zhangsan对象传给了stuHandler中，
 *我们在创建代理对象stuProxy时，将stuHandler作为参数了的，上面也有说到所有执行代理对象的方法都会被替换成执行invoke方法，
 *也就是说，最后执行的是StuInvocationHandler中的invoke方法。所以在看到下面的运行结果也就理所当然了。
 *
 *动态代理的优势在于可以很方便的对代理类的函数进行统一的处理，而不用修改每个代理类中的方法。
 *是因为所有被代理执行的方法，都是通过在InvocationHandler中的invoke方法调用的，
 *所以我们只要在invoke方法中统一处理，就可以对所有被代理的方法进行相同的操作了。
 *例如，这里的方法计时，所有的被代理对象执行的方法都会被计时，然而我只做了很少的代码量。
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
public class ProxyTest {
    public static void main(String[] args) {
        
        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");
        
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);
        
        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(
                Person.class.getClassLoader(), //和目标对象的类加载器保持一致
        		Person.class.getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
        		stuHandler);//InvocationHandler:事件处理器，即对目标对象方法的执行
       //代理执行上交班费的方法
        stuProxy.giveMoney();
    }
}
/**
 
 /**
 * 动态代理对象，无需实现任何接口
 * 通过传入任何类型的目标对象并指定接口
 * 调用JDK接口动态创建代理对象
 
public class ProxyFactory {
 
    private Object targetObject;
     
    public ProxyFactory(Object targetObject) {
        this.targetObject = targetObject;
    }
     
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(), //和目标对象的类加载器保持一致
                targetObject.getClass().getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
                new InvocationHandler() { //InvocationHandler:事件处理器，即对目标对象方法的执行
                     
                    @Override
                    public Object invoke(Object DesignPattern.proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前拦截...");
                         
                        Object result = method.invoke(DesignPattern.proxy, args);
                         
                        System.out.println("后拦截...");
                        return result;
                    }
                });
    }
}
  */
