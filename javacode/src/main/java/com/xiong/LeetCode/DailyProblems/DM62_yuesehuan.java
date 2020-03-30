package com.xiong.LeetCode.DailyProblems;

import com.xiong.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 10:39
 * @description： 面试题62. 圆圈中最后剩下的数字  约瑟环问题
 * @modified By：
 * @version: $
 */
public class DM62_yuesehuan {
    public static void main(String[] args) {
        System.out.println(lastRemaining_re(5,3));
    }

    //数学做法  推荐答案
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/30 11:14
     *  @Description:
     *
     *  反向推出这个数字在之前每个轮次的位置。
     *
     * 最后剩下的 3 的下标是 0。
     *
     * 第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
     *
     * 第三轮反推，补上 m个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
     *
     * 第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
     *
     * 第三轮反推，补上 m  个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
     *
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     */
    public int lastRemaining_math(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推  其实 从 1 开始 也可以
        //任何数 % 1 = 0
        for (int i = 1; i <= n; i++) {
            ans = (ans + m) % i; //ans的含义是 下标
        }
        return ans;
    }
    //递归
    public static int lastRemaining_re(int n, int m) {
        if (n == 1) return 0;
        int x = lastRemaining_re(n - 1, m);//x 为 序列长度为 n-1 时 最后剩下的 结果的下标 下标从0开始
        return (m + x) % n;
    }

    //模拟做法
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        for (int i = n; i > 1; i--) { // 每次 少一个人
            index--;
            index = (index + m) % i; //得到 删除的 index
            list.remove(index);
        }
        return list.get(0);
    }

}
