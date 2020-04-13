package com.xiong.InterviewQuestions;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 17:23
 * @description： 子类
 * 此题考查  类初始化  和 实例初始化 相关内容：
 *  1  （静态变量 静态代码块）> (普通变量  普通代码块) >  构造器 初始化顺序
 *      构造器永远最后  同级别 看谁在前
 *  2  子父类初始化顺序： 先初始化父类  然后子类
 *  3  子类普通方法对父类普通方法的覆写
 *
 *  子类 的 类初始化：
 *  父类静态：（5）（1）
 *  子类静态：（10）（6）
 *
 *  实例初始化：
 *  父类：（9）（3）（2） //方法覆写了！！！！！！  所以 这里是 （9）
 *  子类： （9）（8）（7）
 * @modified By：
 * @version: $
 */
public class Son extends Father{
    private int i = method();
    private static int j = staticMethod();

    static {
        System.out.print("(6)");
    }
    Son(){
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }
    @Override //方法覆写了！！！！！！
    public int method(){
        System.out.print("(9)");
        return 1;
    }

    public static int staticMethod(){
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        //什么都不写时  -》 Son类 类初始化（先父类） 结果 (5)(1)(10)(6)
        Son son = new Son(); //(5)(1)(10)(6) (9)(3)(2)(9)(8)(7) //方法覆写了！！！！！！
        System.out.println();
        //此时类初始化已经完成了 对应 <clinit> 方法 不用再次执行
        //但是 实例初始化  对应方法 <init> 有几个 new  就运行几次
        Son son1 = new Son(); //(9)(3)(2)(9)(8)(7)
    }
}
