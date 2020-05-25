package com.xiong.LeetCode.StringsProblem;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/20 9:43
 * @description：  1371. 每个元音包含偶数次的最长子字符串
 *
 * 前缀和 +  状态压缩  看不懂拉倒
 * @modified By：
 * @version: $
 */
public class Leet1371_findTheLongestSubstring {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }

    public static int findTheLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int status =0;
        int[] position = new int[1 << 5];// 一个5位的二进制数来表示5个元音的奇偶状态
        //一共32种状态。。。
        Arrays.fill(position, -1);
        position[0] = 0; // 0 基础位
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c == 'a'){
                status ^= (1 << 0); // 1
            }else if(c == 'e'){
                status ^= (1 << 1); // 2
            }else if(c == 'i'){
                status ^= (1 << 2); // 4
            }else if(c == 'o'){
                status ^= (1 << 3); // 8
            }else if(c == 'u'){
                status ^= (1 << 4); // 16
            }

            if (position[status] >= 0){
                ans = Math.max(ans, i + 1 - position[status]);
            }else{
                position[status] = i + 1;//就是记录每种状态第一次出现的位置，后面再出现直接减就得到长度了
            }

        }
        return ans;
    }
}
