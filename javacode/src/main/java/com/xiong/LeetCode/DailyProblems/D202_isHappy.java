package com.xiong.LeetCode.DailyProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/30 9:29
 * @description： 202 . 快乐数
 * @modified By：
 * @version: $
 */
public class D202_isHappy {

    public static void main(String[] args) {
        System.out.println(new D202_isHappy().isHappy_set(19));
    }

    private int getNext(int n){
        int newN = 0;
        //取出 每位
        while (n > 0){
            int t = n % 10;
            newN += t*t;
            n /= 10;
        }
        return newN;
    }
    //set 判断循环
    public boolean isHappy_set(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            if (!set.contains(n)){
                set.add(n);
            }else{ // 出现了循环
                return false;
            }
            n = getNext(n);
        }
        return true;
    }
    // 单链表 快慢指针 成环检测
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    // 数学方法
    //只有一个循环：4 16 37 58 89 145 42 20 4
    // 所有其他数字都在进入这个循环的链上，或者在进入 1 的链上。
    private boolean isHappy_math(int n ){
        Set<Integer> deadSet = new HashSet<>(Arrays.asList(4,16,37,58,89,145,42,20));
        while (n != 1){
            if (deadSet.contains(n)){
                return false;
            }
            n = getNext(n);
        }
        return true;
    }
}
