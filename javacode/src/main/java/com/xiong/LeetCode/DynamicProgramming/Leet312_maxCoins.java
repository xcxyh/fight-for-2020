package com.xiong.LeetCode.DynamicProgramming;

import com.xiong.LeetCode.Solution;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/19 17:08
 * @description： 312. 戳气球  自顶向下记忆化搜索 或者是 自下而上的 dp table
 * @modified By：
 * @version: $
 */
public class Leet312_maxCoins {

    /**
     *  @author: xiongcong
     *  @Date: 2020/7/19 17:12
     *  @Description:
     *  我们观察戳气球的操作，发现这会导致两个气球从不相邻变成相邻，
     *  使得后续操作难以处理。于是我们倒过来看这些操作，将全过程看作是每次添加一个气球。
     *
     * 我们定义方法 solve() ，令 solve(i,j) 表示将开区间 (i,j)
     * 内的位置全部填满气球能够得到的最多硬币数。
     * 由于是开区间，因此区间两端的气球的编号就是 i 和 j，对应着
     * val[i] 和 val[j]。
     *
     */
    // 自顶向下记忆化搜索
    private int[][] memo; // memo 记忆数组，防止重复计算
    private int[] newNums;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        newNums = new int[n + 2];

        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[n + 1] = 1;

        memo = new int[n + 2][n + 2];

        for(int i = 0 ; i< n + 2; i++){
            Arrays.fill(memo[i], -1);
        }
        // 求解 开区间 （0，n + 1） 内的 最大 硬币数
        solve(0, n + 1);

        return memo[0][n + 1];
    }


    private int solve(int left, int right){
        // 由于是开区间  left , right 要保证 至少含有一个元素
        if (left >= right - 1){
            return 0;
        }

        if (memo[left][right] != -1){
            return memo[left][right];
        }
        for(int i = left + 1; i < right; i++){
            // 当前值 为 左端点 值 * 当前值 * 右端点值
            int curVal = newNums[left] * newNums[i] * newNums[right];

            int sum = curVal + solve(left, i) + solve(i, right);

            memo[left][right]= Math.max(memo[left][right], sum);
        }

        return memo[left][right];
    }


    public int maxCoins_dptable(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // 左端点 从 n -1 开始
            for (int j = i + 2; j <= n + 1; j++) { // 右端点
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }
}
