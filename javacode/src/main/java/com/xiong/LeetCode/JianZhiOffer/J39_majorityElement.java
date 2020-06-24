package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/15 21:46
 * @description： 面试题39. 数组中出现次数超过一半的数字
 * @modified By：
 * @version: $
 */
public class J39_majorityElement {

    public int majorityElement(int[] nums) {
        //1 hashMap 统计 次数
        //2 排序之后，众数 一定过数组中间点， 直接返回 nums[len / 2]
        //3 moore 投票算法， 用count 统计票数， 最终票数大于0 对应的那个数
        // moore 投票算法 为最优解
        int count = 0;
        int ans = nums[0];
        for(int x : nums){
            if (count == 0 || ans == x){
                ans = x;
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}
