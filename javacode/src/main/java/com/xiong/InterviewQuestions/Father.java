package com.xiong.InterviewQuestions;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 17:23
 * @description： 父类
 * 类初始化时：
 * 静态 : (5)(1)
 * 实例初始化：
 * 普通：（9）（3） //方法覆写了！！！！！！  所以 这里是 （9）
 * 构造器：（2）
 * @modified By：
 * @version: $
 */
public class Father {
    private int i = method();
    private static int j = staticMethod();

    static {
        System.out.print("(1)");
    }
    Father(){
        System.out.print("(2)");
    }
    {
        System.out.print("(3)");
    }

    public int method(){
        System.out.print("(4)");
        return 1;
    }
    public static int staticMethod(){
        System.out.print("(5)");
        return 1;
    }


}
