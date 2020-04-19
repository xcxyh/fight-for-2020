package com.xiong.LeetCode.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/17 17:59
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet707_MyDoublyLinkedList {

    public static void main(String[] args) {
        Leet707_MyDoublyLinkedList obj = new Leet707_MyDoublyLinkedList();
        obj.addAtHead(1);
        obj.deleteAtIndex(0);
        System.out.println(obj.get(0));
    }

    private int size;
    private MyListNode dummyHead;
    private MyListNode dummyTail;

    private class MyListNode{
        int val;
        MyListNode next;
        MyListNode prev;

        public MyListNode(){}

        public MyListNode(int val){
            this.val=val;
        }

        public MyListNode(int val,MyListNode next,MyListNode prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    /** Initialize your data structure here. */
    public Leet707_MyDoublyLinkedList() {
        dummyHead=new MyListNode();
        dummyTail=new MyListNode();
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>size-1)
            return -1;
        else
            return getIndexNode(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0){
            addAtIndex(0,val);
        }else if(index<=size){
            MyListNode currNode=getIndexNode(index);
            MyListNode node=new MyListNode(val);
            MyListNode prevNode=currNode.prev;
            node.prev=prevNode;// prev <-  node
            node.next=currNode;// node -> cur
            currNode.prev=node;// node <- cur
            prevNode.next=node;// prev -> node
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >=0 && index<size){
            MyListNode currNode=getIndexNode(index);
            MyListNode prevNode=currNode.prev;
            MyListNode nextNode=currNode.next;
            prevNode.next=currNode.next;
            nextNode.prev=currNode.prev;
            currNode.prev=null;
            currNode.next=null;
            size--;
        }
    }

    public MyListNode getIndexNode(int index){
        MyListNode curr;
        if(index<=size/2){
            curr=dummyHead.next;
            for(int i=0;i<index;i++,curr=curr.next){}
        }else{
            curr=index==size?dummyTail:dummyTail.prev;
            for (int i=0;i<size-index-1;i++,curr=curr.prev){};
        }
        return curr;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer("head <-> ");
        MyListNode tempNode=dummyHead.next;
        for (int i=0;i<size;i++,tempNode=tempNode.next){
            stringBuffer.append(tempNode.val+" <-> ");
        }
        stringBuffer.append("tail");
        return stringBuffer.toString();
    }
}
