package com.xiong.LeetCode.RaceOfWeek;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/24 12:11
 * @description：   第 190 场周赛  这真是最简单的一场了  排名：755 / 3350
 * @modified By：
 * @version: $
 */
public class Race_190 {
    // 1   5416. 检查单词是否为句中其他单词的前缀  通过
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for(int i = 0 ; i < strs.length; i++){
            String s = strs[i];
            if (s.startsWith(searchWord)){
                return i + 1;
            }
        }
        return -1;
    }

    //2 5417. 定长子串中元音的最大数目  通过
    public int maxVowels(String s, int k) {
        // qianzhuihe
        int[] sum = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            char c = s.charAt(i-1);
            if (isyuanyin(c)){
                sum[i] = sum[i-1] + 1;
            }else{
                sum[i] =sum[i-1];
            }
        }
        int ans = 0;
        for(int i = k; i <= s.length(); i++){
            int t = sum[i] - sum[i - k];
            ans = Math.max(ans, t);
        }
        return ans;
    }
    private boolean isyuanyin(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    //3 5418. 二叉树中的伪回文路径   通过
    private List<List<Integer>> ans = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null){
            return 0;
        }
        preorder(root, new ArrayList<>());
        int count = 0;
        for(List<Integer> list : ans){
            int[] bucket = new int[10];
            for(int n : list){
                bucket[n]++;
            }
            int cnt = 0;
            for(int temp : bucket){
                if (temp % 2 != 0){
                    cnt++;
                }
            }
            if (cnt <= 1){
                count++;
            }
        }
        return count;
    }
    private void preorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
        }
        preorder(root.left, list);
        preorder(root.right, list);
        list.remove(list.size() - 1);
    }

    //4  5419. 两个子序列的最大点积  草  差一点点啊  就 ak了  感觉错过一个亿
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //dp[i][j] 表示 A[1---i] 和 序列 B[1---j] 的子序列最大点积。
        int[][] dp = new int[len1 + 1][len2 + 1];
        //init
        dp[1][1] = nums1[0]*nums2[0];
        for(int i = 2; i <= len1; i++){
            dp[i][1] = Math.max(dp[i-1][1], nums1[i-1]*nums2[0]);
        }
        for(int i = 2; i <= len2; i++){
            dp[1][i] = Math.max(dp[1][i-1], nums1[0]*nums2[i-1]);
        }
        for(int i = 2; i<= len1; i++){
            for(int j = 2; j <= len2; j ++){
                //dp[i][j] = nums1[i - 1] * nums2[j - 1]; // 漏了一种情况 草
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j-1]);
                dp[i][j] =Math.max(dp[i][j], dp[i-1][j - 1] + nums1[i-1]* nums2[j-1]);
                // 这种情况是 当 dp[i-1][j - 1] 为 负 时， 会变小
                dp[i][j] = Math.max(dp[i][j], nums1[i - 1] * nums2[j - 1]); // 漏了一种情况 草
            }
        }
        return dp[len1][len2];
    }


}
