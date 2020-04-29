package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/25 10:09
 * @description： 46. 全排列    回溯模板 题
 * @modified By：
 * @version: $
 */
public class Leet46_permute {


    /*
    LinkedList result = new LinkedList();
    public void backtrack(路径，选择列表){
        if(满足结束条件){
             result.add(结果);
             return;
        }
        for(选择：选择列表){

            // 一些必要的剪枝操作

            做出选择;
            backtrack(路径，选择列表);
            撤销选择;
        }
    }
    */

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        int len = nums.length;
        backtracking(nums, new ArrayList<>(), new boolean[len]);
        return ans;
    }

    private void backtracking(int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list)); // 再新建一个 否则 添加进去的为同一个对象
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            backtracking(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }


    }
}
