package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/26 9:19
 * @description：  面试题 02.01. 移除重复节点
 * @modified By：
 * @version: $
 */
public class Leet02_01_removeDuplicateNodes {


    //利用set 实现 ，还可以利用两个指针 两层遍历，O(n^2) 复杂度？？？这也叫进阶？
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            if (!set.contains(cur.val)){
                set.add(cur.val);
                pre = cur;
            }else{
                pre.next = cur.next;
                cur.next = null;
            }
            cur = next;
        }

        return head;
    }
}
