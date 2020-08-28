package com.xiong.LeetCode.RaceOfWeek;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/2 12:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Race_200 {
    // 1 1534. 统计好三元组
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1;j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k])<= c){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    // 2 1535. 找出数组游戏的赢家
    public int getWinner(int[] nums, int k) {
        int n = nums.length;
        if (k >= n){
            int max = nums[0];
            for(int x : nums){
                if (max < x){
                    max = x;
                }
            }
            return max;
        }

        //
        LinkedList<Integer> list = new LinkedList<>();

        for(int x : nums){
            list.add(x);
        }

        int count = 0;
        int winner = 0;
        while(true){
            int a0 = list.get(0);

            int a1 = list.get(1);

            if (a0 < a1){
                list.removeFirst();
                list.addLast(a0);
                winner = a1;
                count = 1;
            }else{
                list.remove(1);
                list.addLast(a1);
                winner = a0;
                count++;
            }

            if (count >= k){
                return winner;
            }
        }
    }

    //3 1536. 排布二进制网格的最少交换次数
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList<>();
        // 统计 每行 从右向左的连 0 的个数
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 0){
                    cnt++;
                }else{
                    break;
                }
            }
            list.add(cnt);
        }
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            // 遍历每行 得到 每行 的 分界线 阈值
            int threshold = n - 1 - i;
            for(int j = 0; j < list.size(); j++)
            {
                // 记录 list 中 满足 这个阈值的 第一个结果 ，将这一行 交换上去 需要 j 次
                if(list.get(j) >= threshold)
                {
                    list.remove(j);
                    res += j;
                    break;
                }
            }
        }
        if(!list.isEmpty()) return -1;
        return res;
    }

    // 4 1537. 最大得分
    public int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;

        int len2 = nums2.length;

        // nums1 中 以 元素 nums1[i] 结尾的 maxSum
        // int[] dp1 = new int[len1 + 1];

        // int[] dp2 = new int[len2 + 1];
        int mod = 1000000007;
        int i = 0;
        int j = 0;
        long a  =0;
        long b  = 0;
        while (i < len1 || j < len2) {
            if ( i < len1 && j < len2 && nums1[i] == nums2[j]){
                a = b = Math.max(a, b) + nums1[i];
                i++;
                j++;
            }else if (i < len1 && (j == len2 || nums1[i] < nums2[j])) {
                a = a + nums1[i];
                i++;
            }else if (j < len2 && (i == len1 || nums1[i] > nums2[j])) {
                b = b + nums2[j];
                j++;
            }
        }

        return (int)(Math.max(a, b) % mod);

    }

}
