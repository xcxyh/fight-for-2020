package com.xiong.DataStructureAndAlgorithm;


/**
 * @Title: Node.java
 * @Package:dataStructure
 * @Description:   java实现单链表
 * @author: xcc
 * @date:2019年4月1日
 * @version:V1.0
 */
public class Node {
    //数据域
    public int data;
    //指针域，指向下一个节点
    public Node next;

    public static Node head;

    //构造器1
    public Node() {

    }

    //构造器2
    public Node(int data) {
        this.data = data;
    }

    //构造器3  pre 上一个节点
    public Node(int data, Node pre) {
        this.data = data;
        pre.next = this;
    }

    /**
     * 向链表添加数据
     *
     * @param value
     */
    public static void addData(int value) {
        //初始化要加入的节点
        Node newNode = new Node(value);

        //临时节点
        Node temp = head;

        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        // 已经包括了头节点.next为null的情况了～
        temp.next = newNode;
    }

    /**
     * 获取链表的长度
     *
     * @param head 头指针
     */
    public static int linkListLength(Node head) {

        int length = 0;

        //临时节点，从首节点开始
        Node temp = head.next;

        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    /**
     * 遍历链表
     *
     * @param head 头节点
     */
    public static void traverse(Node head) {

        System.out.print("data：" + head.data);
        //临时节点，从首节点开始
        Node temp = head.next;

        while (temp != null) {

            System.out.print(" -> " + temp.data);

            //继续下一个
            temp = temp.next;
        }
        System.out.println();//换行
    }

    /**
     * 插入节点
     *
     * @param head  头指针
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public static void insertNode(Node head, int index, int value) {


        //首先需要判断指定位置是否合法，
        if (index < 1 || index > linkListLength(head) + 1) {
            System.out.println("插入位置不合法。");
            return;
        }

        //临时节点，从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        //初始化要插入的节点
        Node insertNode = new Node(value);

        while (temp.next != null) {

            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {

                //temp表示的是上一个节点

                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;

                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;

                return;

            }

            currentPos++;
            temp = temp.next;
        }

    }

    /**
     * 根据位置删除节点
     *
     * @param head  头指针
     * @param index 要删除的位置
     */
    public static void deleteNode(Node head, int index) {


        //首先需要判断指定位置是否合法，
        if (index < 1 || index > linkListLength(head) + 1) {
            System.out.println("删除位置不合法。");
            return;
        }

        //临时节点，从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;


        while (temp.next != null) {

            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {

                //temp表示的是上一个节点

                //temp.next表示的是想要删除的节点

                //将想要删除的节点存储一下
                Node deleteNode = temp.next;

                //想要删除节点的下一个节点交由上一个节点来控制
                temp.next = deleteNode.next;


                //Java会回收它，设置不设置为null应该没多大意义了(个人觉得,如果不对请指出哦～)
                deleteNode = null;

                return;

            }
            currentPos++;
            temp = temp.next;
        }
    }

    public static Node partion(Node head, int x) {
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node p1 = dummy1;
        Node p2 = dummy2;
        Node p = head;
        while (p != null) {
            if (p.data < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (dummy1.next == null) {
            return head;
        } else {
            p1.next = dummy2.next;
            p2.next = null;//需要断开
            return dummy1.next;
        }

    }

    /**
     * 找到链表中倒数第k个节点(设置两个指针p1、p2，让p2比p1快k个节点，同时向后遍历，当p2为空，则p1为倒数第k个节点
     *
     * @param head
     * @param k    倒数第k个节点
     */
    public static Node findKNode(Node head, int k) {

        if (k < 1 || k > linkListLength(head))
            return null;
        Node p1 = head;
        Node p2 = head;

        // p2比怕p1快k个节点
        for (int i = 0; i < k - 1; i++)
            p2 = p2.next;


        // 只要p2为null，那么p1就是倒数第k个节点了
        while (p2.next != null) {

            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    /**
     * 删除链表重复数据（冒泡法）保留一个   1 -> 2 -> 3 -> 2 -> 3 -> 6  删除后 1 -> 2 -> 3 -> 6
     *   (不能ac)
     * @param head 头节点
     */
    public static void deleteDuplecate(Node head) {

        //临时节点，(从首节点开始-->真正有数据的节点)
        Node temp = head;

        while ( temp != null && temp.next != null) {
            //当前节点(首节点)的下一个节点
            Node nextNode = temp;
            while (nextNode.next != null) {

                if (nextNode.next.data == temp.data) {

                    //将下一个节点删除(当前节点指向下下个节点)
                    nextNode.next = nextNode.next.next;

                } else {

                    //继续下一个
                    nextNode = nextNode.next;
                }
            }

            //下一轮比较
            temp = temp.next;
        }
        traverse(head);
    }

    /**
     * 删除链表重复数据 给定一个有序链表 只要重复全删除   1 -> 2 -> 2 -> 3 -> 3 -> 6  删除后 1 -> 6
     * 分两种情况：
     * 情形1：头结点不重复
     * 　　输入：1->2->2->3->4->4->5
     * 　　输出：1->3->5
     * 情形2：头结点重复
     * 　　输入：1->1->1->2->3
     * 　　输出：2->3
     *
     * @param head 头节点
     */
    public static Node deleteDuplecateAll(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;
        Node pre = head; //用于记录重复元素前的节点
        Node temp = head.next;

        if (first.data != first.next.data) {//分 头结点不重复 头结点重复 两种情形
            while (temp.next != null) {
                if (temp.data != temp.next.data) {
                    pre = pre.next;
                    temp = temp.next;
                } else {
                    while (temp.data == temp.next.data) {
                        temp = temp.next;
                    }
                    temp = temp.next;
                    pre.next = temp;
                }
            }

        } else {
            while (temp.data == temp.next.data) {
                temp = temp.next;
            }
            temp = temp.next;
            first = temp;
            deleteDuplecateAll(first);
        }
        traverse(first);
        return first;

    }

    /**
     * 递归实现链表的反转  递归法是从最后一个Node开始，在弹栈的过程中将指针顺序置换的。
     * data：6 -> 5
     * data：6 -> 5 -> 4
     * data：6 -> 5 -> 4 -> 3
     * data：6 -> 5 -> 4 -> 3 -> 2
     * data：6 -> 5 -> 4 -> 3 -> 2 -> 1
     *
     * @param node 链表的头节点
     */
    public static Node reverseLinkList(Node node) {

        if (node == null || node.next == null) {
            traverse(node);//遍历链表 ，传入头节点  会打印出整个链
            return node;
        }
        Node temp = node.next;
        Node newNode = reverseLinkList(node.next);
        temp.next = node;
        node.next = null;
        traverse(newNode);//遍历链表 ，传入头节点  会打印出整个链
        return newNode;

    }

    /**
     * 循环实现链表的反转,能完全写对这10行代码的人不足10%
     * 1->2->3->4->null
     * 第一次循环之后  null <- 1  2 -> 3 -> 4
     * 第二次循环之后  null <- 1 <- 2  3 -> 4
     * 第三次循环之后  null <- 1 <- 2 <- 3  4
     * 第四次循环之后  null <- 1 <- 2 <- 3 <- 4
     * 然后node == null 结束循环
     * <p>
     * data：1
     * data：2 -> 1
     * data：3 -> 2 -> 1
     * data：4 -> 3 -> 2 -> 1
     * data：5 -> 4 -> 3 -> 2 -> 1
     * data：6 -> 5 -> 4 -> 3 -> 2 -> 1
     *
     * @param node 链表的头节点
     */
    public static Node reverseList(Node node) {
        //准备两个空结点 pre用来保存先前结点、next用来做临时变量
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next; //下一个节点存到临时变量next中
            node.next = pre;  //当前节点改变指向到pre
            pre = node; // 当前节点 变为pre
            node = next; //下一个节点 变为 当前节点
            traverse(pre);
        }
        return pre;
    }

    public static void main(String[] args) {
        Node As = new Node(1);
        Node A = new Node(2,As);
        Node B = new Node(3, A);
        Node C = new Node(4, B);
        //C.next = A;
        Node D = new Node(3, C);
        Node E = new Node(2, D);
        Node F = new Node(1, E);
        //Node G = new Node(6, F);
        //reverseLinkList(A);
        // Node aaa=   reverseList(A);
        // System.out.println(aaa.data);
        //deleteDuplecateAll(As);
        /*      partion(A,4);*/
        //traverse(A);
        //System.out.println(findMiddleNode(As).data);
        System.out.println(hasCircle(As));
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/26 11:07
     *  @Description: 判断单链表中存储的数据是否是回文
     * 思路：
     * 1 快慢指针寻找中间节点，并翻转前半部分
     *      快指针移动两格 慢指针移动一格 当快指针移动到尾部时，slow指向中间节点 ，并且，通过慢指针将前半部分翻转
     * 2 比较前半部分数据是否和后半部分数据相等
     *      slow 为中间节点  前半部分的头节点为pre  然后判断 pre.data == slow.next.data
     */
    private static boolean isHuiwen(Node head){

        if(head == null && head.next == null){
            return false;
        }
        Node pre =null;//用于翻转
        Node next_fast;
        Node next_slow;
        Node slow = head;//慢指针指向头
        Node fast = head;//快指针指向头
        //快指针移动两格 慢指针移动一格 当快指针移动到尾部时，slow指向中间节点 ，并且，将前半部分翻转
        while (fast.next != null && fast.next.next != null){
            next_fast = fast.next.next; //快指针移动两格，先保存在next中
            next_slow = slow.next;//慢指针移动一格
            //翻转前半部分start
            slow.next = pre;  //当前节点改变指向到pre
            pre = slow; // 当前节点 变为pre
            //翻转前半部分end
            slow = next_slow;//慢指针向下移动
            fast = next_fast; //快指针向下移动
        }

        //此时 slow 为中间节点4  前半部分的头节点为pre  然后判断前半部分和后半部分数据是否相等即可
        while (slow.next != null){
            if(pre.data != slow.next.data){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/26 16:23
     *  @Description: 寻找单链表中的中间节点
     */
    public static Node findMiddleNode(Node node){

        if(node ==null || node.next ==null){
            return node;
        }

        Node slow =node;
        Node fast = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/26 16:42
     *  @Description: 链表中环的检测 快慢指针法
     */
    public static boolean hasCircle(Node node){
        if(node ==null || node.next ==null){
            return false;
        }
        Node slow = node;
        Node fast = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null){// 已到链表末尾
                return false;
            }else if(slow == fast){ // 快慢指针相遇，存在环
                return true;
            }
        }
        return false;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/28 21:00
     *  @Description: 合并两个有序链表  ??
     */
    public static Node merge(Node node1, Node node2) {
        //新建一个新头节点，并创建一个指针 cur 记录当前位置
        Node newNode = new Node();//头节点 ，无数据
        Node cur = newNode;

        //判断 1 和 2 是否为空 不为空  则判断 data大小
        // 小的就添加到 新节点后 然后 小的那个头节点向后移动
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                while (node1 != null && node1.data <= node2.data) {
                    cur.next = node1;
                    cur = cur.next;
                    node1 = node1.next;
                }
            } else {
                while (node2 != null && node2.data <= node1.data) {
                    cur.next = node2;
                    cur = cur.next;
                    node2 = node2.next;
                }
            }
        }
            if (node1 != null) {
                cur.next = node1;
            }
            if (node2 != null) {
                cur.next = node2;
            }
            return newNode.next; // ??
        }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/28 20:56
     *  @Description: 找到并删除倒数第n个节点 双指针法  p2 与 p1 相距 n
     */
    public static Node deleteLastNode(Node node, int n){

        if ( n < 1 ||  n > linkListLength(node)) {
            return null;
        }

        Node pre = null;
        Node p1 = node;
        Node p2 = node;

        for (int i = 0; i <n ; i++) {
            p2 = p2.next;
        }

        while(p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        //此时 slow为要删除的节点

        if(pre != null){
            pre.next = p1.next;
        }else{//当要删除的节点为头节点
            node = p1.next;
        }
        return node;

    }
}
