package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/15 18:19
 * @description： 142. 环形链表 II
 * @modified By：
 * @version: $
 */
public class Leet142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //fast和slow相遇，fast比slow多走了n步,n 为环的大小，
            //x 为 slow 走过的长度  则 fast 走过的长度为 2x  -> 2x - x = n
            // 可知 x = n
            // 假设 z 为 从起点到入口点所需的步数
            // x + z = n + z = 0 + z (因为环的大小为n ，多走n步又返回了入口点，相当于没走，即 0)
            // x + z = z  可知， slow 再走 z 步 (x + z) , fast 返回原点 再走 z 步（此时步长变为1）
            //相遇时，即为入口点
            if( slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
