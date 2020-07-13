package com.xiong.LeetCode.ArrayProblems.TreeArray;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/11 19:39
 * @description： 315. 计算右侧小于当前元素的个数
 * @modified By：
 * @version: $
 */
public class Leet315_countSmaller {

    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        //离散化  放入 a 中
        discretization(nums);
        // 初始化一个
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }
    // 离散化
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        // 利用 set 去重
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        // 放入 一个数组中，然后对数组 排序
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
}
