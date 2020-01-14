package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/3 13:22
 * @description： 给定一个正整数n，将其分解为至少两个正整数的和，并使这些整数的乘积最大化。返回您可以获得的最大乘积。
 * 输入：10
 * 输出：36
 * 说明： 10 = 3 + 3 + 4，3×3×4 = 36。
 * @modified By：
 * @version: $
 */
public class CutRope_14 {
    public static void main(String[] args) {
        integerBreak_dp(10);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/1/3 13:47
     *  @Description:
     * 依题意，绳子至少被剪一次，所以绳子长度最小为2。外层for循环从绳长为i=2的情况开始依次计算，直到计算到绳长为n的情况。
     * 内层for循环：当绳长为i时，由于已知至少剪一刀，我们索性假设第一刀剪在长度为j的位置(即第一段绳子长度为j)。
     * 剩下的那段长度为( i - j )的绳子就变成了“可剪可不剪”。
     * 那究竟是“不剪了”得到的乘积大呢，还是“继续剪余下的这段”得到乘积更大？我们不知道，
     * 所以需要两种情况都计算一下进行比较。其中，“不剪了”得到的乘积是j * ( i - j )，
     * “继续剪”得到的乘积是j * dp[ i - j ]。取其中的较大值，就是“第一剪在j位置”能得到的最大乘积。
     * 而第一剪的所有可能位置是1,2,…,i-1。依次计算所有可能情况，取最大值即为dp[ i ]的值。
     * 由上述过程可知，只有先依次计算出dp[2],dp[3],....的值，才能得到dp[n]的值。此为动态规划。
     */
    public static int integerBreak_dp(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/1/3 13:54
     *  @Description: 贪心
     *  尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
     *  数学证明： 当 f(n) = (L/n)^n 取极大值时， L/n = e  即 每段长度都为 e 时 乘积最大
     *  又 每段长度 为整数 所以取3  即 尽可能多剪长度为 3 的绳子
     */
    public static int integerBreak_greedy(int n) {

        if(n < 2){
            return 0;
        }

        if(n == 2){
            return 1;
        }

        if(n == 3){
            return 2;
        }

        int timeof3 = n / 3; // 3 的个数

        if((n - timeof3 * 3) == 1){ //不允许出现1 当出现 1 时，少一个3 组成 4
            timeof3--;
        }
        int timesof2 = (n - timeof3 * 3) / 2; // 2 的个数

        return (int)(Math.pow(3,timeof3) * Math.pow(2,timesof2)); // 3*3*3*...*2*2
    }
}
