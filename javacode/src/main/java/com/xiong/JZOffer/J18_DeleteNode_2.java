package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/14 15:44
 * @description： 删除 **有序** 链表中重复的结点
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 分两种情况：
 * 情形1：头结点不重复
 * 　　输入：1->2->2->3->4->4->5
 * 　　输出：1->3->5
 * 情形2：头结点重复
 * 　　输入：1->1->1->2->3
 * 　　输出：2->3
 * @modified By：
 * @version: $
 */
public class J18_DeleteNode_2 {

    public static void main(String[] args) {
        ListNode As = new ListNode(1);
        ListNode A = new ListNode(2,As);
        ListNode B = new ListNode(2, A);
        ListNode C = new ListNode(4, B);
        ListNode D = new ListNode(5, C);
        ListNode E = new ListNode(6, D);
        ListNode F = new ListNode(7, E);

        traversalList(new J18_DeleteNode_2().deleteDuplication(As));
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/1/30 17:39
     *  @Description: 递归写法
     */
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;

        if(pHead.data == next.data){//头节点重复

            while(next != null && pHead.data == next.data){
                next = next.next;
            }
            //重复的头节点删除后  接下来的子链 继续去重
            return deleteDuplication(next);

        }else{//头节点不重复
            //该头结点 指向去重后的子链
            pHead.next = deleteDuplication(pHead.next);
        }
        return pHead;
    }


    /**
     *  @author: xiongcong
     *  @Date: 2020/1/30 17:47
     *  @Description: 遍历一个链表
     */
    public static void traversalList(ListNode head){

        if(head == null){
            System.out.println("null");
        }
        //打印头
        System.out.print(head.data);

        ListNode temp = head.next;
        while (temp != null){
            System.out.print(" -> " + temp.data);
            temp = temp.next;
        }
        //换行
        System.out.println();
    }

}
