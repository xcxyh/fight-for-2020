package com.xiong.LeetCode.DailyProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/24 12:36
 * @description： 面试题 17.16. 按摩师  这题考察递归  跟上台阶差不多 上一步 上两步 两种情况
 *
 * 一个有名的按摩师会收到源源不断的预约请求，
 * 每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * @modified By：
 * @version: $
 */
public class D1716_massage {

    public static void main(String[] args) {
        System.out.println(massage(new int[]{0,4,1,4,1,4}));
        // 12533111
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/24 12:34
     *  @Description:
     *  执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     *  内存消耗 :37.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    static Map<Integer,Integer> map = new HashMap<>(); //保存中间结果，避免重复计算
    public static int massage(int[] nums) {
        int ret = 0;
        for (int i = 0; i <nums.length ; i++) {
            ret = Math.max(ret,massage(nums,i));
        }
        return ret;
    }

    private static int massage(int[] nums,int begin) {

        if (begin >= nums.length) {
            return 0;
        }
        if (map.containsKey(begin)){
            return map.get(begin);
        }
        // 跳过 1 个 或跳过两个
        int temp1 =massage(nums,begin +  2);
        int temp2 =massage(nums,  begin + 3);
        int max = Math.max(temp1,temp2);
        map.put(begin,nums[begin] + max);
        return nums[begin] + max;
    }

}
