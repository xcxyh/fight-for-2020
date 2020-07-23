package com.xiong.LeetCode.DynamicProgramming.线性DP;

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
    // 题意分析  0720
    public int superEggDrop(int K, int N) {
        // 如果不限鸡蛋个数， 使用 二分法， 至少 logN 次 移动
        // 但是 现在鸡蛋个数有限，手算都不好算最优解
        // dp(K,N) 表示 K 个鸡蛋 N 层楼，最坏情况下 最小的移动次数
        // dp(K, N) res = min(res , 这次在 第 i 层楼扔鸡蛋 );
        // 状态转移： 在第 i 层楼扔鸡蛋：
        // 鸡蛋碎了，鸡蛋个数减一，只用去 i层以下的楼找 dp(K - 1, i - 1)
        // 鸡蛋没碎，鸡蛋个数不变，要去 i 层以上的楼找 dp(K, N - i)
        // 又要是最坏情况， 就要取 上面两种情况中 较大的那个
        // 即  max(dp(K - 1, i - 1), dp(K, N - i));
        // 又要是最小移动次数，就要取所有最坏情况中 ，最小移动次数的那个最坏情况
        // res = min(res, max(dp(K - 1, i - 1), dp(K, N - i)) + 1);

        return dp_basic(K, N);

    }
    // 能解决问题的版本，但是 复杂度高， 也没有 memo 去除重复计算
    // 会超时，无法通过所有样例
    private int dp_basic(int K, int N){
        // 只有一个鸡蛋，最坏情况是从最高层才会碎，要尝试 N 次
        if (K == 1){
            return N;
        }
        if (N == 0){
            return 0;
        }
        int res =Integer.MAX_VALUE;
        // 线性搜索 所有最坏情况
        for(int i = 1; i <= N; i++){
            res = Math.min(res, Math.max(dp_basic(K - 1, i - 1), dp_basic(K, N - i)) + 1);
        }
        return res;
    }

    //记录中间结果 避免重复计算
    private Integer[][] memo = null; // 用 Integer 对象 不要用 int

    public int superEggDrop_memo(int K, int N) {
        //dp[k][i] 表示 共i层 k 个鸡蛋 时，最坏情况下的最小移动次数
        memo = new Integer[K + 1][N + 1];
        // ans = min( ans, max(dp[k][N-i],dp[k-1][i -1]) + 1 )
        return dp_memo(K, N);

    }
    // 使用 二分法 寻找 最坏情况中的最小值 ，使用 memo 记录 中间结果，避免重复计算
    private int dp_memo(int K, int N) {
        // 只有一个鸡蛋，最坏情况是从最高层才会碎，要尝试 N 次
        if (K == 1){
            return N;
        }
        if (N == 0){
            return 0;
        }
        if (memo[K][N] != null) {
            return memo[K][N];
        }
        int res =Integer.MAX_VALUE;
        //第一种 从第1层楼到第n层楼每层楼开始逐个尝试作为切入点
        // for(int i = 1; i <= N; i++){
        //     res = Math.min(res, Math.max(dp(K - 1, i - 1), dp(K, N - i)) + 1);
        // }

        // 二分法寻找函数 max(dp(K - 1, i - 1), dp(K, N - i)) 最低点
        //第二种 用二分搜索代替线性搜索
        //其实就是求这两条单调递增和单调递减直线的交点
        // 相当于求上半部V形山谷值 二分查找来快速寻找这个点
        int left = 1;
        int right = N;
        // 左闭右闭 区间
        while(left <= right){
            int mid = left + (right - left) / 2;

            int breakCount = dp_memo(K - 1, mid - 1);
            int notBreakCount = dp_memo(K, N - mid);

            if (breakCount > notBreakCount){
                right = mid - 1;
                res =Math.min(res, breakCount + 1);
            }else{
                left = mid + 1;
                res =Math.min(res, notBreakCount + 1) ;
            }
        }
        memo[K][N] = res;
        return res;
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
