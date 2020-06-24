/**  
* Title: Client.java  
* Description: 
* @author：wh
* @date 2019年8月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.cglib;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
/**
 *@class_name：Client
 *@comments:cglib动态代理测试类
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年8月7日
 */
/**
Cglib动态代理执行代理方法效率之所以比JDK的高是因为Cglib采用了FastClass机制，
它的原理简单来说就是：为代理类和被代理类各生成一个Class，这个Class会为代理类或被代理类的方法分配一个index(int类型)。
这个index当做一个入参，FastClass就可以直接定位要调用的方法直接进行调用，这样省去了反射调用，所以调用效率比JDK动态代理通过反射调用高。

至此，Cglib动态代理的原理我们就基本搞清楚了，代码细节有兴趣可以再研究下。
最后我们总结一下JDK动态代理和Gglib动态代理的区别：
	1.JDK动态代理是实现了被代理对象的接口，Cglib是继承了被代理对象。
	2.JDK和Cglib都是在运行期生成字节码，JDK是直接写Class字节码，Cglib使用ASM框架写Class字节码，Cglib代理实现更复杂，生成代理类比JDK效率低。
	3.JDK调用代理方法，是通过反射机制调用，Cglib是通过FastClass机制直接调用方法，Cglib执行效率更高。
	
	Cglib顶层通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类
 */
public class Client {
	public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }


}
