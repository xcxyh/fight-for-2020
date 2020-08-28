package com.xiong;


import java.util.HashMap;
import java.util.Map;

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


    private static  void solve(int n){
        int max =0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= n; i++){
            int temp = i / 10;
            int z = i % 10;
            map.put(i, getSum(temp) + z);
        }


        for(int i = 0; i < n / 2 + 1; i++){
            int a = map.get(i);
            int b = map.get(n - i);

            max = Math.max(max, a+ b);
        }
        System.out.println(max);
    }

    private static int getSum(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x = x /10;
        }
        return sum;
    }

}
