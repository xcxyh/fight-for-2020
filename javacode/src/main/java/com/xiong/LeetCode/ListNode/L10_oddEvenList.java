package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/3 15:29
 * @description： medium
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class L10_oddEvenList {
    /**
     * @author: xiongcong
     * @Date: 2020/3/3 15:33
     * @Description: 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     * <p>
     * 将奇数位置节点连接到一起  偶数节点连接到一起
     * 记录下偶数节点的头节点
     * 然后让 奇数节点的尾节点指向 偶数节点的头节点
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // 不能为odd != null && odd.next != null  因为 even 先移动到尾部
            odd.next = odd.next.next;
            odd = odd.next; //移动到下一个 奇数 3
            even.next = even.next.next;
            even = even.next; //移动到下一个 偶数 4
        }
        //让 奇数节点的尾节点指向 偶数节点的头节点
        odd.next = evenHead;
        return head;
    }
}
