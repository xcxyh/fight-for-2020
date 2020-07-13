package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/1 11:03
 * @description：  面试题57 - II. 和为s的连续正数序列
 * @modified By：
 * @version: $
 */
public class J57_findContinuousSequence {

    public int[][] findContinuousSequence2(int target) {
        // 双指针

        int left = 1;
        int right =1;
        int sum = 0;
        List<int[]> ans = new ArrayList<>();
        while(right < target){
            if (sum < target){
                sum += right;
                right++;
            }else if (sum > target){
                sum -= left;
                left++;
            }else{
                int[] temp = new int[right - left];

                for(int i = left; i < right; i++){
                    temp[i - left] = i;
                }
                ans.add(temp);
                //更新
                sum += right;
                sum -= left;
                left++;
                right++;
            }
        }
        int[][] ret = new int[ans.size()][];

        for(int i = 0; i < ans.size(); i++){
            ret[i] = ans.get(i);
        }

        return ret;
    }




    //这么写  能快很多
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        // 0 不是 正整数
        // 双指针法  返回 一个 二维数组真的烦，因为结果是不定长的
        int left = 1;
        int right = 1;
        int sum = 0;
        while(right <= target / 2 + 2){

            if (sum < target){
                sum += right;
                right++;
            }else if(sum > target){
                sum -= left;
                left++;
            }else{
                if (right - left > 1 ){
                    int[] temp = new int[right - left];
                    for(int i = 0; i < temp.length; i++){
                        temp[i] = i + left;
                    }
                    ans.add(temp);
                }
                sum += right;
                sum -= left;
                left++;
                right++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public int[][] findContinuousSequence_2(int target) {
        List<LinkedList<Integer>> ans = new ArrayList<>();
        // 0 不是 正整数
        // 双指针法  返回 一个 二维数组真的烦，因为结果是不定长的
        int left = 1;
        int right = 1;
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while(right <= target / 2 + 2){

            if (sum < target){
                sum += right;
                list.addLast(right);
                right++;
            }else if(sum > target){
                sum -= left;
                list.removeFirst();
                left++;
            }else{
                if (right - left > 1 ){
                    ans.add(new LinkedList<>(list));
                }
                sum += right;
                sum -= left;
                list.addLast(right);
                list.removeFirst();
                left++;
                right++;
            }
        }
        // 这里做转换  耗时过长
        int[][] ret = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            LinkedList<Integer> temp  = ans.get(i);
            int[] t = new int[temp.size()];
            for(int j = 0; j < temp.size(); j++){
                t[j] = temp.get(j);
            }
            ret[i] = t;
        }
        return ret;
    }
}
