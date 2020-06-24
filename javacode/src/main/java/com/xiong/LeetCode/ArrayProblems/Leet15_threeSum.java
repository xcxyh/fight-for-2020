package com.xiong.LeetCode.ArrayProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/12 12:48
 * @description：   15. 三数之和
 * @modified By：
 * @version: $
 */
public class Leet15_threeSum {

    public static void main(String[] args) {
        System.out.println(new Leet15_threeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        //排序
        Arrays.sort(nums);
        //
        int n = nums.length;
        //  三个元素 在 数组中的 位置   i -----  l ----- r
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            if(nums[i] > 0){
                continue;
            }
            // 需要进行去重操作
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 第三个数 从 尾部开始
            int r =  n - 1;
            for (int l =  i + 1; l < n; l++) {

                //去重操作
                if (l > i + 1 && nums[l] == nums[l - 1]){
                    continue;
                }
                // 移动 第三个数
                while (l < r && nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
                if (l == r){
                    break;
                }
                if (nums[i] + nums[l] + nums[r] == 0){
                    ans.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                }
            }
        }
        return ans;
    }

}
