package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/3 19:46
 * @description：
 * @modified By：
 * @version: $
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class J35_randomListNodeClone {

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        // 1 在每个后面复制一个 它本身
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        cur = pHead;
        //2 复制 random 指向
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 3 拆分
        cur = pHead;
        RandomListNode pcloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pcloneHead;
    }
}
