package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/4 11:34
 * @description：   45. 跳跃游戏 II
 * @modified By：
 * @version: $
 */
public class Leet45_jump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    //
    public static int jump(int[] nums) {
        //贪心  2 3 1 1 4  起始位置能 跳到 3 和 1，而 3 比 1 大
        // 贪心的跳到 数字3 的位置上
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 0; //记录当前轮能跳到的最远位置
        int end = 0; // 记录当前轮的最后一个位置
        int step = 0; // 轮数
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == end ){
                end = max;
                step++;
            }

        }
        return step;

    }
}
