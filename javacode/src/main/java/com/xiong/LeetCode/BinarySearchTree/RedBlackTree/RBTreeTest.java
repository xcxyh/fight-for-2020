package com.xiong.LeetCode.BinarySearchTree.RedBlackTree;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/27 17:30
 * @description：  红黑树测试类
 * @modified By：
 * @version: $
 */
public class RBTreeTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AtomicInteger atomicInteger = new AtomicInteger();
        RBTree<String, Object> rbTree = new RBTree<>();
        while (true){
            //请输入key
            System.out.println("请输入key, 输入 exit 退出");
            String key = sc.next();
            if ("exit".equals(key)){
                break;
            }
            System.out.println();
            rbTree.insert(key, null);
            //打印出tree 结构
            TreeOperation.show(rbTree.getRoot());
        }
        System.out.println("测试结束");
    }
}
