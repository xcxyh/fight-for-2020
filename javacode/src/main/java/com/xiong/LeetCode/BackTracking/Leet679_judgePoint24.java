package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/22 10:36
 * @description：  679. 24 点游戏
 * @modified By：
 * @version: $
 */
public class Leet679_judgePoint24 {


    private static final double EPSILON = 1e-6; // epsilon
    public boolean judgePoint24(int[] nums) {

        List<Double> list = new ArrayList<>();

        for(int x : nums){
            list.add((double)x);
        }

        return solve(list);
    }

    private boolean solve(List<Double> list){

        if (list.size() == 0){
            return false;
        }

        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < EPSILON;
        }

        int size = list.size();
        // 选出两个位置不同的数字（大小可以相同）
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                if (i != j){
                    double n1 = list.get(i);
                    double n2 = list.get(j);
                    List<Double> nextList = new ArrayList<>();

                    // 找出 不在 i 和 j 两个位置的其他数字 先加到 nextList
                    for(int m = 0; m < size; m++ ){
                        if (m != i && m != j){
                            nextList.add(list.get(m));
                        }
                    }

                    //对 n1 n2  做四则运算
                    for(int k = 0; k < 4; k++){
                        // + 和 * 运算 满足交换律
                        // 例： 2 + 3 算了  就不用再算  3 + 2 了
                        if (k < 2 && i > j){
                            continue;
                        }

                        if (k == 0) { nextList.add(n1 + n2); }
                        if (k == 1) { nextList.add(n1 * n2); }
                        if (k == 2) { nextList.add(n1 - n2); }
                        if (k == 3 ) {
                            if (Math.abs(n2) < EPSILON){
                                continue;
                            } else{
                                nextList.add(n1 / n2);
                            }
                        }
                        // 满足就直接返回
                        boolean flag = solve(nextList);
                        if (flag) {
                            return true;
                        }
                        // 移除最后一个计算结果，因为最后的记过不满足要求
                        // 就是一种回溯方法，将前面添加的结果删除
                        nextList.remove(nextList.size() - 1);
                    }

                }
            }
        }

        return false;
    }
}
