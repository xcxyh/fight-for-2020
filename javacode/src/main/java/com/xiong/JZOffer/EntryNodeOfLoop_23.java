package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/2 11:58
 * @description： 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 解法：
 * 1 使用hashset ，将经过的节点存入 set  当存入失败时，该节点即为 入口节点
 * <p>
 * 2 使用断链法，在确定包含环的情况下使用断链法找出入口节点
 * <p>
 * 3 双指针法：
 * 首先，快慢指针检测是否有环；
 * 如果有环，这时fast和slow相遇，fast比slow多走了n步，2x - n = x ---> x = n , n 为环的大小
 * x 为慢指针走过的步数  假设 入口节点在 z 处  则 z + n = x + z,
 * 此时，慢指针再继续走 z 步 到达入口节点， 快指针从头开始走 z 步 到达 入口结点
 * 即 慢指针继续走， 快指针从头开始走， 步长此时都为 1 ，再次相遇的节点即为 入口节点
 * @modified By：
 * @version: $
 */
public class EntryNodeOfLoop_23 {
    public static void main(String[] args) {
        ListNode As = new ListNode(1);
        ListNode A = new ListNode(2,As);
        ListNode B = new ListNode(3, A);
        ListNode C = new ListNode(4, B);
        ListNode D = new ListNode(5, C);
        ListNode E = new ListNode(6, D);
        ListNode F = new ListNode(7, E);
        F.next = C;//制造环
        System.out.println(EntryNodeOfLoop(As).data);
        System.out.println();
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/2 14:23
     * @Description: 方法3
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast.next.next != null && slow.next != null) {
            //快指针一次两步 慢指针一次一步
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) { //当相遇时
                fast = pHead; //快指针从头开始走
                while (fast != slow) { //一次一步
                    fast = fast.next;
                    slow = slow.next; //慢指针继续走
                }
                //当再次相遇时 返回的slow即为入口节点
                return slow;
            }
        }
        return null;
    }
}
