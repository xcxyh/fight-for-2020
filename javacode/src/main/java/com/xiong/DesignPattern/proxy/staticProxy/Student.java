
package com.xiong.DesignPattern.proxy.staticProxy;


public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }
    

    public String getName(){
        return  name;
    }

    public void giveMoney() {
       System.out.println(name + "上交班费50元");
    }
}
