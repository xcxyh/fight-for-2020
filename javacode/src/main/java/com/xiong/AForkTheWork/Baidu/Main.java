package com.xiong.AForkTheWork.Baidu;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/29 18:46
 * @description：  百度
 * @modified By：
 * @version: $
 */
public class Main {

    public static void main(String[] args) {
      ListNode head =   ListNode.generateListNodeFromArr(new int[]{3,1,4,2,5});

        System.out.println(quickSort(head));

        //System.out.println(find);

    }

    public ListNode sortList(ListNode head) {
        return quickSort(head);
    }


    // 交换节点 而不是交换 值 的 快排, 效率最低，
    private static ListNode quickSort(ListNode head){
        if(head == null || head.next == null) return head;

        int pivot = head.val;
        // 链表划分
        ListNode ls = new ListNode(-1), rs = new ListNode(-1);
        ListNode l = ls, r = rs, cur = head;

        while(cur != null){
            if(cur.val < pivot){
                l.next = cur;
                l = l.next;
            }else{
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        // 这两句不能交换 ，否则链表成环
        r.next = null;
        l.next = rs.next;

        // 递归调用,先重排右边的,再把指针置空,再重排左边的
        // 和归并排序很像的
        ListNode right = quickSort(head.next);
        head.next = null;
        ListNode left = quickSort(ls.next);

        // 拼接左半部分和右半部分
        cur = left;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = right;

        return left;

    }

    private static boolean find(int[][] matrix, int target){

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = rows - 1;
        int j = 0;

        while(i >= 0 && j < cols){

            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }else{
                return true;
            }

        }
        return false;
    }


}
