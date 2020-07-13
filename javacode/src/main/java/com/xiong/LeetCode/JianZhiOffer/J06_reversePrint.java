package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.ListNode;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/7 9:14
 * @description：
 * @modified By：
 * @version: $
 */
public class J06_reversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = reverseList(head);

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for(int x : list){
            ans[i++] = x;
        }


        return   ans;
    }

    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
