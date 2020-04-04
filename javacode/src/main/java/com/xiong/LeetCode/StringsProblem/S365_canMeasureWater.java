package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/21 17:07
 * @description： 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 *  * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *  * <p>
 *  * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *  * <p>
 *  * 你允许：
 *  * <p>
 *  * 装满任意一个水壶
 *  * 清空任意一个水壶
 *  * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * @modified By：
 * @version: $
 */
public class S365_canMeasureWater {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(2, 6, 5));
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/21 16:40
     * @Description: 输入: x = 3, y = 5, z = 4
     * 输出: True
     * <p>
     * 问题可以转花为找到m和n使得mx + ny = k，
     * 其中m，n可以为正数或负数。对于这类问题，
     * 数学上可以证明只要x，y的最大公约数能整除k，
     * 就存在一对m，n实现mx + ny = k。
     * 因此问题就转化为寻找x,y的最大公约数是否能整除k。
     * <p>
     * 找到 x y 的最大公约数 看能否被 z 整除 碾转相减法
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0){
            return true;
        }
        if (x == 0){
            return y == z;
        }
        if (y == 0){
            return x == z;
        }
        if(x + y < z){
            return false;
        }
        return z % mcd(x, y) == 0;
    }
    // 碾转相减法 找到 x y 的最大公约数
    private static int mcd(int a, int b) {

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return a == b ? a : mcd(b, a - b);

    }
    //碾转相除法 求最大公约数
    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
