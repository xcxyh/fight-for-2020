package com.xiong.LeetCode.DynamicProgramming.线性DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/14 10:02
 * @description： 120. 三角形最小路径和
 * @modified By：
 * @version: $
 */
public class Leet120_minimumTotal {


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal_new(triangle));
    }

    public static int minimumTotal_new(List<List<Integer>> triangle) {
        // 先将 这个三角形 左对齐
        //  [2],
        //  [3,4],
        //  [6,5,7],
        //  [4,1,8,3]
        // 从下向上 得到 最小值
        int n = triangle.size();
        int[] dp = new int[n + 1];

        // dp 表示当前层 i 位置上的 最小值
        for(int i = n - 1; i >= 0; i--){
            List<Integer> curLevel = triangle.get(i);
            for(int j = 0; j <= i; j++){

                dp[j] = Math.min(dp[j], dp[j + 1]);

                dp[j] += curLevel.get(j);
            }
        }

        return dp[0];
    }

    //    作者：sweetiee
    //    链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //自底向上
    public int minimumTotal_1(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // 自顶向下 很复杂
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i] 到达第i层 的 最小路径和
        int size = triangle.size();
        int[] dp = new int[size];

        //init
        for (int i = 0; i < size; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            int len = i + 1;
            List<Integer> layer = triangle.get(i);
            for (int j = len - 1; j >= 0; j--) {
                int min = dp[j];
                if (j > 0) {
                    min = Math.min(min, dp[j - 1]);
                }

                dp[j] = layer.get(j) + min;
                //System.out.print(dp[j] + " ");
            }
            // System.out.println();
        }

        int ans = dp[0];
        for (int x : dp) {
            if (x < ans) {
                ans = x;
            }
        }
        return ans;
    }
}
