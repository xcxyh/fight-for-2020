package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/3 14:00
 * @description： medium
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * @modified By：
 * @version: $
 */
public class L9_splitListToParts {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(7);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        new L9_splitListToParts().splitListToParts(head,3);
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/3 15:16
     *  @Description: 官方解答 没有新建过对象
     */
    public ListNode[] splitListToPartsL(ListNode root, int k) {
        //边界
        if (root == null){
            return  new ListNode[k];
        }
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0); //这里
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }

    //改造后
    public ListNode[] splitListToParts_new(ListNode root, int k) {
        //边界
        if (root == null){
            return  new ListNode[k];
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = root;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        ListNode[] result = new ListNode[k];
        //判断长度与k值的关系
        int avelenth = len / k;
        int reminder = len % k;
        int count = 0;
        cur = root;
        // len / k = avelenth 余 reminder 则 前面有 reminder个 avelength + 1  长度的 子链表
        while(count < k){
            int curSize = (reminder-- > 0)? avelenth : avelenth - 1;
            if (cur != null) {
                result[count++] = cur;
                for (int l = 0; l < curSize; l++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }else{
                result[count++] = null;
            }
        }
        return result;
    }

    //终于ac 了
    //效率低  有新建对象和代码重复
    //改造前
    public ListNode[] splitListToParts(ListNode root, int k) {
        //边界
        if (root == null){
            return  new ListNode[k];
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = root;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        ListNode[] result = new ListNode[k];
        //判断长度与k值的关系
        int avelenth = len / k;
        int reminder = len % k;
        int count = 0;
        cur = root;
        // len / k = avelenth 余 reminder 则 前面有 reminder个 avelength + 1  长度的 子链表
           while(count < k){
                while (reminder-- > 0){ //注意 这里不能写for 这段代码只运行 reminder次 所以写成 while
                    if (cur != null) {
                        ListNode temp = new ListNode(cur.val);
                        ListNode temp_cur = temp; // 这是temp的指针
                        for (int l = 0; l < avelenth ; l++) {
                            cur = cur.next;
                            temp_cur.next = new ListNode(cur.val);
                            temp_cur = temp_cur.next;
                        }
                        result[count++] = temp;
                        cur = cur.next;
                    }else{
                        result[count++] = null;
                    }
                }

               if (cur != null) {
                   ListNode temp = new ListNode(cur.val);
                   ListNode temp_cur = temp;// 这是temp的指针
                   for (int l = 0; l < avelenth - 1; l++) {
                       cur = cur.next;
                       temp_cur.next = new ListNode(cur.val);
                       temp_cur =temp_cur.next;
                   }
                   result[count++] = temp;
                   cur = cur.next;
               }else{
                   result[count++] = null;
               }
            }
        return result;
    }

}
