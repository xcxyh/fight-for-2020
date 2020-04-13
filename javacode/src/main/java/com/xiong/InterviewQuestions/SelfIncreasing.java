package com.xiong.InterviewQuestions;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/12 17:05
 * @description：  局部变量表 和 操作数栈
 * @modified By：
 * @version: $
 */
public class SelfIncreasing {
    /**
     *  @author: xiongcong
     *  @Date: 2020/4/12 17:10
     *  @Description:  看懂不容易哦
     *  局部变量表
     *  i
     *  j
     *  k
     *  操作数栈
     *
     *  赋值操作 最后执行
     */
    public static void main(String[] args) {
        int i = 1;  //此时 局部变量表中 i 为 1
        //先将 i 为 1 压入 操作数栈, 然后 ++ 局部变量表中 i 变为了 2
        //然后再将操作数栈中的 1 赋值给i, 此时 局部变量表中 i 变为了 1
        i = i++;//这句之后 i 仍为 1

        //同理 将操作数栈中的 1 赋值给j, 局部变量表中 j 变为了 1
        // 然后 ++  此时 局部变量表中 i 变为了 2
        int j = i++;//这句之后，j 为 1 ，i 为 2

        // 一：此时 i 为 2，将 2 压人操作数栈，
        // 二：++ 将 局部变量表中 i 变为了 3
        // 三：然后再将 3 压人操作数栈
        // 四：将 3 压人操作数栈
        // 五：++ 将 局部变量表中 i 变为了 4
        // 六：操作数栈中：2 + 3 * 3 = 11
        // 最后将 11 赋值给 局部变量表 中的 k
        int k = i + ++i * i++;

        System.out.println(i);// 4
        System.out.println(j);//1
        System.out.println(k);// 11
    }
}
