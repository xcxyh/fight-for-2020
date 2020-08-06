package com.xiong;


/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 11:25
 * @description： 单链表
 * @modified By：
 * @version: $
 */
public class ListNode {

    public ListNode next;

    public int val;

    public ListNode head;

    public ListNode(int x) {
        this.val = x;
    }  //赋值链表的值
    public ListNode(int x, ListNode pre) {
        pre.next = this;
        this.val = x;

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/6/25 17:16
     *  @Description: 工具类，根据 数组 生成 单链表，返回头节点
     */
    public static ListNode generateListNodeFromArr(int[] arr) {
        if (arr == null || arr.length < 1){
            return null;
        }
        ListNode newHead = new ListNode(arr[0]);
        ListNode cur = newHead;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return newHead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("val：");
        sb.append(this.val);
        //临时节点，从首节点开始
        ListNode temp = this.next;

        if (isCircle()){
            return "链表成环。";
        }

        while (temp != null) {

            sb.append(" -> ");
            sb.append(temp.val);
            //继续下一个
            temp = temp.next;
        }
       //sb.append("\n");

        return sb.toString();
    }

    private boolean isCircle(){

        ListNode slow = this;
        ListNode fast = this.next;
        while (fast != null && fast.next != null){

            if (fast == slow){
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;

        }
        return false;
    }

}
