package com.xiong.LeetCode.JianZhiOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/2 9:09
 * @description： 面试题61. 扑克牌中的顺子
 * @modified By：
 * @version: $
 */
public class J61_isStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int laizi = 0;  //癞子 个数
        int gap = 0; // 缺省牌
        for(int i = 0 ; i < 4; i++){
            if (nums[i] != 0){
                if (nums[i] == nums[i + 1]){ // 有相同的牌，而且不为 大小王 返回 false
                    return false;
                }
                gap += nums[i + 1] - nums[i] - 1;
            }else{
                laizi++;
            }
        }

        return gap <= laizi;
    }
}
