package com.xiong.JZOffer;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/10 13:54
 * @description： 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * @modified By：
 * @version: $
 */
public class IsPopOrder_31 {

    public static void main(String[] args) {
        System.out.println();
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/10 14: 00
     *  @Description: 构造一个栈  来模拟 进出栈
     */
    public static boolean isPopOrder(int[] pushSeq , int[] popSeq){

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i <pushSeq.length ; i++) {
            stack.push(pushSeq[i]);
            //判断栈顶元素等于出栈序列中的元素时 stack 出栈
            while(j < pushSeq.length && !stack.isEmpty() && stack.peek() == popSeq[j] ){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}
