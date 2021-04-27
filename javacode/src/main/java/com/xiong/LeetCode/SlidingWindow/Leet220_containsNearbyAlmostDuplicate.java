package com.xiong.LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/17 10:06
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet220_containsNearbyAlmostDuplicate {


    //先不管k参数，将问题简化为：数组nums中是否存在两个下标i和j，使得Math.abs(nums[i] - nums[j]) <= t
    //那么题目就和217题（https://leetcode-cn.com/problems/contains-duplicate/）基本一样了，实现代码为：
    //Set<Integer> set = new HashSet<>();
    //for(int num : nums){
    //    if(!containsNearby(set, num, t))
    //        return true;
    //    set.add(num);
    //}
    //return false;
    //其中containsNearby(set, num, t)方法用于判断set中是否包含[num - t, num + t]范围内的数字
    //由于t可能特别大，因此使用暴力法逐个查看[num - t, num + t]中的数是否存在于set中是不现实的
    //应该换个角度来理解：containsNearby(set, num, t)方法用于判断set中是否存在一个元素i，使得i和num的距离不大于t
    //这就引出了桶分组算法；桶分组算法在第164题（https://leetcode-cn.com/problems/maximum-gap/）中也有提及

    //我们先不管nums数组中的元素，只关心t的大小；假设t是5
    //那么我们可以把0~5当作是第0组，6~11当作第1组，12~17当作第2组，依此类推
    //现在，假设set中只有一个第3组的元素x和一个第9组的元素y：
    //1. 问containsNearby(set, 30, 5)返回值是多少？
    //  - 显然返回false，因为30是第5组的元素，它和第3组的元素x之间间隔了至少6个数，与第9组的距离就更远了
    //2. 问containsNearby(set, 20, 5)返回值是多少
    //  - 显然返回true，因为20是第3组的元素，而set中已经有了一个第3组的元素x，那么20和x的间隔肯定不超过5
    //3. 问containsNearby(set, 24, 5)返回值是多少
    //  - 不确定；24是第4组的，它和第9组距离很远自然不必说，但x可能是[18, 23]区间中的其中一个数，因此需要依x而定

    //综上，我们就可以确定containsNearby(set, num, t)方法的实现思路了：
    //1. 先判断num是第几组的（当然，具体的分组方式由t决定），假设是第n组
    //2. 如果set中已经有第n组的数，则返回true；否则如果没有第(n + 1)和(n - 1)组的任何数，则返回false
    //2. 如果有第(n + 1)或(n - 1)组的数，则判断num是否与这些数的距离小于等于t

    //了解了containsNearby(set, num, t)方法的实现思路后，再结合第219题，后面的代码就不难理解了

    //获取数字num的组别，其中每个组的最大值与最小值之差为t，即一组能容纳(groupLen = t + 1)个数字
    //显然，[0, groupLen - 1]是第0组，[groupLen, 2 * grouupLen - 1]是第1组
    //注意，[-groupLen, -1]应该属于第-1组，因此当num是负数时需要留意
    public static int getGroupNum(int num, int t){

        //如果t已经是int的最大值了，那么显然全体非负数是第0组，全体负数是第-1组
        if(t == Integer.MAX_VALUE)
            return num >= 0 ? 0 : -1;

        //如果num是非负数，那么直接返回(num / groupLen)即可
        //如果num是负数，则返回(num + 1) / groupLen - 1，这一点请自行举例来帮助理解
        return num >= 0 ? num / (t + 1) : (num + 1) / (t + 1) - 1;
    }

    //趁热打铁，先实现containsNearby(set, num, t)方法
    //但是注意，这里应该使用Map而不是Set来存储数组的元素
    //假设数字n属于第g组，则上文中的set.add(n)就相当于这里的buckets.put(g, n)
    public static boolean containsNearby(Map<Integer, Integer> buckets, int num, int t){

        //获取num所在的组的编号
        int g = getGroupNum(num, t);

        //如果集合中已经存在这一组的元素，则返回true
        if(buckets.get(g) != null)
            return true;

        Integer g1 = buckets.get(g + 1), g2 = buckets.get(g - 1);

        //如果第(g + 1)和(g - 1)组均没有元素，则返回false
        if(g1 == null && g2 == null)
            return false;

        //如果有第(g + 1)/(g - 1)组的元素，则判断该元素与num的距离是否大于t
        //注意要转成long类型再进行减法运算，避免溢出
        return (g1 != null && (long)g1 - num <= t) || (g2 != null && (long)num - g2 <= t);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0)
            return false;

        //滑动窗口[left, right)
        int left = 0, right = 0;

        //用于存放滑动窗口中的元素
        Map<Integer, Integer> buckets = new HashMap<>();

        //不断往集合添加元素
        while(right < nums.length){
            int num = nums[right++];
            if(containsNearby(buckets, num, t))
                return true;
            buckets.put(getGroupNum(num, t), num);

            //如果集合大小达到了(k + 1)，则删除最开始的元素
            if(right - left == k + 1)
                buckets.remove(getGroupNum(nums[left++], t));
        }
        return false;
    }
}
