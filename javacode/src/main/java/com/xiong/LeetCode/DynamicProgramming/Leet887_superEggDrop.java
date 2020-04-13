package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 9:52
 * @description：887. 鸡蛋掉落  困难
 * <p>
 * 动态规划
 * @modified By：
 * @version: $
 */
public class Leet887_superEggDrop {
    /**
     * @author: xiongcong
     * @Date: 2020/4/11 11:27
     * @Description: 具体题解看 labuladong 小抄上的  高楼扔鸡蛋
     * <p>
     * dp(k,n) 由于局部使用线性搜索（for循环遍历），会超时
     * <p>
     * 可以将 for循环遍历 改造成二分查找
     */
    //记录中间结果 避免重复计算
    private Integer[][] memo = null; // 用 Integer 对象 不要用 int

    public int superEggDrop(int K, int N) {
        //dp[k][i] 表示 共i层 k 个鸡蛋 时，最坏情况下的最小移动次数
        memo = new Integer[K + 1][N + 1];
        // ans = min( ans, max(dp[k][N-i],dp[k-1][i -1]) + 1 )
        return dp(K, N);

    }

    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[k][n] != null) {
            return memo[k][n];
        }
        int ans = Integer.MAX_VALUE;
        //第一种 从第1层楼到第n层楼每层楼开始逐个尝试作为切入点
        /*for(int i = 0; i < n; i++){
            ans = Math.min( ans, Math.max(dp(k,n - i),dp(k - 1,i - 1)) + 1 );
        }*/
        //第二种 用二分搜索代替线性搜索
        //其实就是求这两条单调递增和单调递减直线的交点
        // 相当于求上半部V形山谷值 二分查找来快速寻找这个点
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int eggBreak = dp(k - 1, mid - 1);
            int eggUnBreak = dp(k, n - mid);
            if (eggBreak > eggUnBreak) {  // max
                hi = mid - 1;
                ans = Math.min(ans, eggBreak + 1);
            } else {
                lo = mid + 1;
                ans = Math.min(ans, eggUnBreak + 1);
            }
        }

        memo[k][n] = ans;
        return ans;
    }


    /**
     * @author: xiongcong
     * @Date: 2020/4/11 11:38
     * @Description: 逆向思维   复制打卡的一天
     */
    public int superEggDrop_dp(int K, int N) {
        //修改dp 数组的定义
        // dp[k][m] = n 表示 k个鸡蛋 尝试 m 次，最坏情况下最多能确切测试一栋 n 层的楼
        //总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。
        //dp[k][m] = dp[k][m-1] + dp[k-1][m - 1] + 1
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N){ // ???
            m++;
            for (int k = 1; k < K; k++) {
                dp[k][m]= dp[k][m-1] + dp[k-1][m-1] + 1;
            }
        }
        return m;
    }
}
