package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/24 15:32
 * @description： 给定一个只包含整数的有序数组，
 * 每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * @modified By：
 * @version: $
 */
public class B3_singleNonDuplicate {
    /**
     * @author: xiongcong
     * @Date: 2020/2/24 15:44
     * @Description: 要求： 时间复杂度为log n  (难)
     * 没有复杂度要求 则可以用 遍历数组 相邻元素 异或
     * 令 index 为 Single Element 在数组中的位置。
     * 在 index 之后，数组中原来存在的成对状态被改变。
     * 之前状态为 nums[m] = nums[m+1]  则 index 一定在 区间 [m+2,high]内
     * <p>
     * 在index 之后  nums[m] != nums[m+1] 则 index 一定在 [low,m] 内
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1; //由于数组中有一个单元素 所以 数组长度为奇数  high 为偶数
        while (low < high) {
            int mid = low + (high - 1) / 2;
            if (mid % 2 == 1) { // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
