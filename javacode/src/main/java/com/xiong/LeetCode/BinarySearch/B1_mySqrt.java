package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/23 17:01
 * @description： 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @modified By：
 * @version: $
 */
public class B1_mySqrt {

    public static void main(String[] args) {
        System.out.println(new B1_mySqrt().mySqrt_Newton(3));
    }
    //二分法
    public int mySqrt(int x) {

        if (x <= 1){
            return x;
        }
        long left = 0;
        long right = x / 2; // 一个数的平方根 一定小于 等于  x / 2
        while(left < right){
            // 这里选择右中位数
            // 注意：针对特殊测试用例，例如 2147395599
            // 要把搜索的范围设置成长整型
            long mid = left + (right - left + 1) / 2;

            if (mid * mid > x){
                right = mid - 1;
            }else {
                left = mid;
            }

        }
        return (int) left;
    }

    //牛顿法 f(x) = x^2 - a ,求 x 。  =====>  x' = 1/2 * ( x + a / x)
    public int mySqrt_Newton(int a) {
        double x = 1.0;
        while (Math.abs(x * x - a) > 0.01) { // 可调精度
            x = (x + a / x) / 2.0;
        }
        return (int) x;
    }

}
