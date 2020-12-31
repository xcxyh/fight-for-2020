package com.xiong.LeetCode.DanDiaoStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/20 12:16
 * @description： 316. 去除重复字母  单调栈
 * @modified By：
 * @version: $
 */
public class Leet316_removeDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        // 这个保证 单调栈里面 不会有重复字符
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)){
                while (!stack.isEmpty() && c < stack.peek() && arr[stack.peek() - 'a'] > 0){
                    set.remove(stack.pop());
                }

                stack.push(c);
                set.add(c);
            }
            // 这个遍历过了 就要 -1  不能放到 while 里面
            arr[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();

        while(! stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
