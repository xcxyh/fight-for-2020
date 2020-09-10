package com.xiong.LeetCode.MathProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/9 9:21
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1104_pathInZigZagTree {


    public List<Integer> pathInZigZagTree(int label) {

        int x = (int) (Math.log(label) / Math.log(2)) + 1;
        List<Integer> list = new ArrayList<>();
        list.add(0, label);
        while (x > 1) {
            x--;
            // 上一个为  label / 2 的对称点
            int temp = label / 2;
            //对称点 为 上一层 左右端点的和 - temp
            // 例 ： 4 5 6 7    6 的对称点 为  4 + 7 - 6 = 5
            int uplabel = (int) (Math.pow(2, x) - 1 + Math.pow(2, x - 1)) - temp;
            list.add(0, uplabel);
            label = uplabel;
        }

        return list;
    }
}
