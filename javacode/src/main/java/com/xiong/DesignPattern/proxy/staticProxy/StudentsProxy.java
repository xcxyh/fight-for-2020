/**  
* Title: StudentsProxy.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.staticProxy;

/**
 *@class_name：StudentsProxy
 *@comments:
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
/**
 * 学生代理类，也实现了Person接口，保存一个学生实体，这样既可以代理学生产生行为
 * @author Gonjan
 *
 */
public class StudentsProxy implements Person{
    //被代理的学生
    Student stu;
    
    public StudentsProxy(Person stu) {
        // 只代理学生对象
        if(stu.getClass() == Student.class) {
            this.stu = (Student)stu;
        }
    }
    
    //代理上交班费，调用被代理学生的上交班费行为
    public void giveMoney() {
        System.out.println("班长：我帮"+ stu.getName() +"交");
        stu.giveMoney();
        System.out.println("班长："+ stu.getName() +"交过了");
    }
}
