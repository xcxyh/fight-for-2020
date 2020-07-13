package com.xiong.LeetCode;


import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 9:38
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    public static void main(String[] args) {

        StringBuilder ans = new StringBuilder();
        //System.out.println(Arrays.toString(insertSort(new int[]{5,4,6,9,7,));
        ArrayList<Integer> list = new ArrayList<>();
        //Collections.reverse(list);
        System.out.println(isNumber("-1"));
        String[] strs = new String[1];
        list.toArray(new Integer[0]);
        Arrays.sort(strs, (o1, o2) -> (o1 + o2) .compareTo (o2 + o1));
        Set<Integer> set = new HashSet<>();
    }



    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }

        char[] chars = s.trim().toCharArray();
        int n = chars.length;

        if (n == 0){
            return false;
        }

        int i = 0;
        int dot = 1; // 小数点 可以当作一个数字 但是只能出现一次
        //".1"  "3." "+.8"  "46.e3" 都可以
        // "+." ".e" 不行
        while( i < n){

            //以-， +，数字 开头
            if (chars[i] == '+' || chars[i] == '-'
                    || chars[i] == '.' || Character.isDigit(chars[i])){
                if (chars[i] == '+' || chars[i] == '-' ){
                    ++i;
                    // 以-， +， 开头 后面只能跟数字 或 点
                    if (i == n || (i < n && ! Character.isDigit(chars[i]) && chars[i] != '.')){
                        return false;
                    }
                    if (i < n && chars[i] == '.'){
                        ++i;
                        if (i == n){
                            return false;
                        }
                    }
                }else if (chars[i] == '.'){
                    ++i;
                    --dot;
                    if (i == n || (i < n && ! Character.isDigit(chars[i])) ){
                        return false;
                    }
                }else{
                    ++i;
                }

                // 跳过数字
                while(i < n && Character.isDigit(chars[i]) ){
                    ++i;
                }
                if (i < n && chars[i] == '.'){
                    if (dot == 0){
                        return false;
                    }
                    --dot;
                    ++i;
                    if (i < n && !Character.isDigit(chars[i]) && chars[i] != 'e'){
                        return false;
                    }
                }
                // 跳过数字
                while(i < n && Character.isDigit(chars[i]) ){
                    ++i;
                }
                // 如果是 e
                if (i < n && chars[i] == 'e'){
                    ++i;
                    //以-， +， 开头
                    if (i < n && (chars[i] == '+' || chars[i] == '-')){
                        ++i;
                    }
                    if (i == n){
                        return false;
                    }
                    while(i < n && Character.isDigit(chars[i])){
                        ++i;
                    }

                    if (i < n){
                        return false;
                    }

                }else if (i < n){
                    return false;
                }

            }else{
                return false;
            }

        }

        return true;
    }

    public static  int numWays(int n) {
        if (n == 0)
        {
            return 1;
        }
        if (n <= 2 ){
            return n;
        }

        int pre_one = 1;

        int pre_two = 2;
        int ans = 0;
        for(int i = 3; i < n; i++){
            ans = pre_one + pre_two;
            pre_one = pre_two;
            pre_two = ans;
        }
        return ans;
    }

    public static int minSubArrayLen(int s, int[] nums) {
        //滑动窗口
        if (nums == null || nums.length == 0){
            return 0;
        }


        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;

        int ans = n + 1;
        while(right < n){
            if (sum < s){
                sum += nums[right];
                right++;
            }

            while(sum >= s){
                sum -= nums[left];
                left++;
                ans = Math.min(ans, right - left);
            }
            //
        }
        return ans;

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || pushed.length == 0){
            return true;
        }
        // 用一个栈模拟
        // 遇到 poped 中的元素就 pop
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(j < popped.length ){

            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            if (i < pushed.length){
                stack.push(pushed[i++]);
            }else{
                break;
            }

        }



        return stack.isEmpty();
    }

}