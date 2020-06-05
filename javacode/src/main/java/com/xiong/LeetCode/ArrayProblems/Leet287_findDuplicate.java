package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/26 11:35
 * @description： 287. 寻找重复数  这竟然是一个 判断是否有环的问题
 * @modified By：
 * @version: $
 */
public class Leet287_findDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow =  nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = 0;

        while(fast != slow){
            fast = nums[fast];
            slow =  nums[slow];
        }
        return slow;
    }
}
