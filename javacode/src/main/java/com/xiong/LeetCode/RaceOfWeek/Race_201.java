package com.xiong.LeetCode.RaceOfWeek;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/9 10:24
 * @description：      太难了
 * @modified By：
 * @version: $
 */
public class Race_201 {
    public static void main(String[] args) {
        System.out.println(new Race_201().minCost(7, new int[]{1,3,4,5}));
    }

    // 1 整理字符串  ac  错了一次
    public String makeGood(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isright(c, stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private boolean isright(char c1, char c2) {

        if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) {
            return c1 - 'A' == c2 - 'a';
        } else if (Character.isUpperCase(c2) && Character.isLowerCase(c1)) {
            return c2 - 'A' == c1 - 'a';
        }
        return false;
    }

    //2 找出第 N 个二进制字符串中的第 K 位  ac  错了一次
    public char findKthBit(int n, int k) {

        if (n == 1) {
            return '0';
        }
        // 我吐了  想这个长度想了半天
        int len = (1 << n) - 1;  // 2^n == (1 << n)

        int mid = len / 2 + 1;
        if (k < mid) {
            return findKthBit(n - 1, k);
        } else if (k > mid) {
            // 这里 mid * 2 - k 得到 reverse 之前的位置
            char temp = findKthBit(n - 1, mid * 2 - k);
            // invert
            if (temp == '0') {
                return '1';
            } else {
                return '0';
            }
        } else {
            return '1';
        }
    }

    // 3 和为目标值的最大数目不重叠非空子数组数目  超时了一次
    public int maxNonOverlapping(int[] nums, int target) {

        // 不重叠的 前缀和 问题
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        // 存的是 和 出现的次数
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i< n; i++){
            sum += nums[i];

            if (map.containsKey(sum - target)){
                ans++;
                // 清空结果 保证不重叠
                map.clear();
                map.put(0,1);
                sum = 0;
            }else{
                map.put(sum, 1);
            }
        }
        return ans;
    }

    // 4  切棍子的最小成本  gg
    public int minCost(int n, int[] cuts) {
        // 反过来思考

        //dp[i][j] 表示 从 第i根 到 第j根 之间合并 所需的最小成本

        Arrays.sort(cuts);
        int m = cuts.length;
        // 各段棍子的长度
        int[] sticks = new int[m + 1];
        // sticks 数组的前缀和
        int[] preSum = new int[m + 2];

        sticks[0]  = cuts[0];
        preSum[0] = 0;
        for(int i = 1; i < m; i++){
            sticks[i] = cuts[i] - cuts[i - 1];

            preSum[i] = preSum[i - 1] + sticks[i - 1];
        }
        sticks[m] = n - cuts[m - 1];

        preSum[m] = preSum[m - 1] + sticks[m - 1];
        preSum[m + 1] = preSum[m] + sticks[m];


        int[][] dp = new int[m + 1][m + 1];

        //init
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= m; j++) {
                dp[i][j] = 100000000;
            }
        }
        // 单独一根不需要 成本
        for(int i = 0; i <= m; i++){
            dp[i][i] = 0;
        }
        // 遍历所有的长度
        for(int len = 1 ; len <= m + 1; len++){
            for(int i = 0; i + len - 1 < m + 1; i++){
                int j = i + len - 1;
                // 根据 前缀和 得到 从 i 到 j 棍子的总长度
                int val = preSum[j + 1] - preSum[i];

                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + val);
                }
            }

        }

        return dp[0][m];
    }

}
