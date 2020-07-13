package com.xiong.JZOffer;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/14 15:22
 * @description： 在 O(1) 时间内删除链表节点  这里指的是均摊复杂度O（1）
 * @modified By：
 * @version: $
 */
public class J18_DeleteNode_1 {

    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        //边界
        if (head == null || tobeDelete == null) {
            return null;
        }
        //该节点不为尾节点  复杂度为 O(1)
        if (tobeDelete.next != null) {
            //1 将tobeDelete的next节点的值复制给tobeDelete
            tobeDelete.val = tobeDelete.next.val;
            //2 然后tobeDelete指向它的next.next 节点
            tobeDelete.next = tobeDelete.next.next;
        }
        //该节点为尾节点 复杂度为 O(n)
        else {
            //只有一个节点
            if(head == tobeDelete){
                head = null;
            }
            ListNode cur = head;
            //1 遍历该链表找到tobeDelete的前节点
            while (cur.next != null) {
                if (cur.next.next == null) {
                    //2然后让这个前节点指向null
                    cur.next = null;
                    break;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}
