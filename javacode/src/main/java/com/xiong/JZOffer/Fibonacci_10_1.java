package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/14 13:27
 * @description： 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @modified By：
 * @version: $
 */
public class Fibonacci_10_1 {
    public static void main(String[] args) throws Exception{
        System.out.println(fibonacci(4));
    }

    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:30
     *  @Description: 解1：递归：该方法会重复计算一些子问题，例如在计算 f(4) = f(3) + f(2) 时就重复计算了 f(2)
     */
    public static int fibonacci(int n) throws Exception {
        if(n < 0){
            throw new Exception("为负");
        }
        if( n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }


    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:45
     *  @Description: 动态规划将 子问题计算的值都 缓存到数组中，避免了重复计算子问题
     */
    public static int fibonacci_dp1(int n){

        if(n <= 1){
            return n;
        }
        int[] res = new int[n+1];
        res[1]=1;
        for (int i = 2; i < n+1 ; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:47
     *  @Description:  由于该问题 只需要前两个值，所以不用将所有的结果缓存，只需缓存前两个即可。
     */
    public static int fibonacci_dp2(int n){

        if(n <= 1){
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i = 2; i < n+1 ; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

}
