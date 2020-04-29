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
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        while (low <= high) { // 循环条件 为  <=
            int m = low + (high - low) / 2;
            int sqrt = x / m;
            if (sqrt == m) {
                return m;
            } else if (m > sqrt) { //在左半部分
                high = m - 1;
            } else { //在右半部分
                low = m + 1;
            }
        }
        //没找到 就返回 保留整数的部分，小数部分将被舍去。
        //此时 high < low  所以 返回 high
        return high;

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
