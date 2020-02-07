package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/4 15:07
 * @description： 合并两个有序链表  要求 合并后仍有序
 * @modified By：
 * @version: $
 */
public class MergeList_25 {

    public static void main(String[] args) {

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/4 15:09
     *  @Description: 递归
     */
    public static ListNode merge(ListNode list1,ListNode list2){

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode result = null;

        if(list1.data <= list2.data){
            result = list1;
            list1.next = merge(list1.next,list2);
        }else {
            result = list2;
            list2.next = merge(list1,list2.next);
        }
        return result;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/4 15:25
     *  @Description: 非递归
     *  要注意 list1 和list2 长度不同时，要将长的那个的剩余的子链加到 newnode的后面
     */
    public ListNode merge_2(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode curnode=null;
        ListNode newnode=null;
        while(list1!=null&&list2!=null)
        {
            if(list1.data<list2.data)
            {
                if(newnode==null)
                {
                    curnode=list1;
                    newnode=curnode;
                }
                else
                {
                    curnode.next=list1;
                    curnode=curnode.next;
                }
                list1=list1.next;

            }
            else
            {
                if(newnode==null)
                {
                    curnode=list2;
                    newnode=curnode;
                }
                else
                {
                    curnode.next=list2;
                    curnode=curnode.next;
                }
                list2=list2.next;
            }
        }
        if(list1==null)
        {
            curnode.next=list2;

        }
        else
        {
            curnode.next=list1;
        }
        return newnode;
    }

}
