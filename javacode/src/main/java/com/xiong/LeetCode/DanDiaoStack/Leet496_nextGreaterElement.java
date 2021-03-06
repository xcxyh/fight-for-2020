package com.xiong.LeetCode.DanDiaoStack;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/11 13:37
 * @description：  496. 下一个更大元素 I
 * @modified By：
 * @version: $
 */
public class Leet496_nextGreaterElement {


    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        int n = nums2.length;

        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0;  i< n; i++) {

            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                next[stack.pop()] = nums2[i];
            }

            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {

            nums1[i] = next[map.get(nums1[i])];
        }

        return nums1;
    }


    /**
     // 单调栈的通用写法 ：
     //        for(遍历数组){
     //
     //            while(!stack.isEmpty() && stack.peek() 与数组中元素的比较){
     //                stack.pop();
     //                ......
     //            }
     //            stack.push(数组元素或下标等);
     //        }
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2 == null || nums2.length == 0){
            return nums2;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] ans = new int[n1];
        //维护一个单调减的栈， 只要当前元素大于 栈顶元素， 就不断出栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        // 单调栈的 通用写法
        for(int n : nums2){
            while(!stack.isEmpty() && stack.peek() < n){
                int key = stack.pop();
                map.put(key, n);
            }
            stack.push(n);
        }

        for(int i = 0; i < n1; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }

}
