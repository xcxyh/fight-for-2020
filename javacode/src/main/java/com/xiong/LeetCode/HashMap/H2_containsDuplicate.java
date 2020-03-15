package com.xiong.LeetCode.HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 17:13
 * @description  数组中的重复元素
 * @modified By：
 * @version: $
 */
public class H2_containsDuplicate {
        //使用set
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length;
    }
}
