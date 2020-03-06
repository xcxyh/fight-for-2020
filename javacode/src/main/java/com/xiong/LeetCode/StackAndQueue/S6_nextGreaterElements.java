package com.xiong.LeetCode.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/5 12:10
 * @description： 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class S6_nextGreaterElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new S6_nextGreaterElements().nextGreaterElements(new int[]{1, 2, 1})));
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/5 13:21
     *  @Description:
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[len];
        Arrays.fill(result, -1);
        for (int i = 0; i < len * 2; i++) {
            int curNum = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < curNum) {
                result[stack.pop()] = curNum;
            }
            if (i < len) {
                //入栈索引
                stack.push(i);
            }
        }
        return result;
    }


}
