package com.xiong.AForkTheWork.ByteDance;

import com.xiong.ListNode;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 19:48
 * @description： 25. K 个一组翻转链表  二面
 * @modified By：
 * @version: $
 */
public class Leet25_reverseKGroup {

    private ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            // 该 局部  不 足 k 个点 时  直接返回
            if (b == null) {
                return head; // 直接返回  不反转！！
            }
            b = b.next;
        }
        // 局部翻转之后 的 新头节点
        ListNode newHead = reverseBetween(a, b);
        // 反转之后  a 就 变成了  上一个局部的 尾节点 ，然后 和 之后的部分连接起来
        a.next = reverseKGroup(b, k);
        // 返回这个局部反转的 新头节点
        return newHead;
    }

    //  局部反转方法
    // [a, b)  不包括 右端点
    private ListNode reverseBetween(ListNode a, ListNode b) {

        ListNode pre = null;
        while (a != b) {
            ListNode next = a.next;
            a.next = pre;
            pre = a;
            a = next;
        }

        return pre;

    }


    //    作者：DeadCrow
//    链接：https://www.nowcoder.com/discuss/450088
//    来源：牛客网
    public ListNode reverseKGroup2(ListNode head, int k) {
        // 建立一个哨兵节点用来返回
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 两个指针用来保存需要反转数组的前后节点，用来恢复链表
        ListNode pre = dummy;
        ListNode next = dummy;
        // 需要一个 head 和 tail 用来保存被反转链表的头和尾
        ListNode tail = head;
        while (next != null) {
            tail = head;
            // 找到尾节点
            for (int i = 1; i < k && tail != null; i++)
                tail = tail.next;
            // 如果不满足 k 个了，那么此时 tail 为 null，直接跳出循环
            if (tail == null) {
                break;
            }
            //将尾结点的 next 保存并设为 null
            next = tail.next;
            tail.next = null;
            // 反转节点
            pre.next = reverseList(head);
            // 重新赋值
            head.next = next;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        String str1 = "111";
        String str2 = "111";
        String str3 = new String("111");
        String str4 = new String("111");
        System.out.println(str1 == str2); // true

        System.out.println(str1 == str3); // false

        System.out.println(str3 == str4); // false


        class test implements Callable{
            @Override
            public Object call() throws Exception {
                return null;
            }
        }
        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<>(new test());
        new Thread(result).start();


    }

}
