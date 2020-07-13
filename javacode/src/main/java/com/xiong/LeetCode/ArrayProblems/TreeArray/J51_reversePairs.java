package com.xiong.LeetCode.ArrayProblems.TreeArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/11 19:40
 * @description： 剑指 Offer 51. 数组中的逆序对 ---- 离散化树状数组  用树状数组解决逆序数问题，也是一个经典的做法。
 * @modified By：
 * @version: $
 */
public class J51_reversePairs {

    /**
     *
     * 树状数组是一种实现了高效查询「前缀和」与「单点更新」操作的数据结构.
     * 「树状数组」是一种可以动态维护序列前缀和的数据结构，它的功能是：
     *
     * 单点更新 update(i, v)： 把序列 i 位置的数加上一个值 vv，这题 v = 1
     * 区间查询 query(i)： 查询序列[1⋯i] 区间的区间和，即 ii 位置的前缀和
     * 修改和查询的时间代价都是 O(logn)，其中 n 为需要维护前缀和的序列的长度。
     *
     *具体的做法是：
     *
     * 先离散化，将所有的数组元素映射到 0、1、2、3... ，这是为了节约树状数组的空间；
     * 从后向前扫描，边统计边往树状数组里面添加元素，这个过程是「动态的」，需要动手计算才能明白思想。
     *
     */

    public static void main(String[] args) {
       new J51_reversePairs().reversePairs(new int[]{1,5,3,4,6,8,7,2});
    }
    // 解法二： 离散化树状数组
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        // 离散化：使得数字更紧凑，节约树状数组的空间
        // 1、使用二分搜索树是为了去掉重复元素
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            treeSet.add(nums[i]);
        }

        // 2、把排名存在哈希表里方便查询
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rankIndex = 1;
        for (Integer num : treeSet) {
            rankMap.put(num, rankIndex);
            rankIndex++;
        }

        int count = 0;
        // 在树状数组内部完成前缀和的计算
        // 规则是：从后向前，先给对应的排名 + 1，再查询前缀和
        FenwickTree fenwickTree = new FenwickTree(rankMap.size());

        for (int i = len - 1; i >= 0; i--) {
            int rank = rankMap.get(nums[i]);
            fenwickTree.update(rank, 1);
            count += fenwickTree.query(rank - 1);
        }
        return count;
    }
    // 树状数组
     class FenwickTree {
        private int[] tree;
        private int len;

         FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        /**
         * 单点更新：将 index 这个位置 + delta
         *
         * @param i
         * @param delta
         */
        private void update(int i, int delta) {
            // 从下到上，最多到 size，可以等于 size
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }


        // 区间查询：查询小于等于 tree[index] 的元素个数
        // 查询的语义是「前缀和」
        private int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }

}
