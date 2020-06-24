/**  
* Title: Student.java  
* Description: 
* @author：wh
* @date 2019年4月7日
* @version 1.0
* Company: itiis
*/  
package com.xiong.DesignPattern.proxy.dynamicProxy.jdk;

/**
 *@class_name：Student
 *@comments:
 *@param:
 *@return: 
 *@author:wh
 *@createtime:2019年4月7日
 */
public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }
   
    public void giveMoney() {
        try {
          //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println(name + "上交班费50元");
    }
}
