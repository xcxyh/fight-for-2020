package com.xiong.JZOffer;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/10 14:50
 * @description： 三种打印二叉树的 方式
 * @modified By：
 * @version: $
 */
public class J32_PrintBinaryTree {
    public static void main(String[] args) {
  /*
          3
         / \
        9   20
       /    /  \
      4    15   7
        */
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = new TreeNode(4);
        node2.left = node3;
        node2.right = node4;
        ArrayList<Integer> list =  new J32_PrintBinaryTree().Print1(root);
        for (Integer it:list
             ) {
            System.out.print(it + " ");
        }
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/11 16:05
     *  @Description: 使用队列来进行层次遍历。
     *  把二叉树打印成多行
     */
    public ArrayList<Integer> Print1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt > 0) {
                cnt--;
                TreeNode t = queue.poll();//出队
                if (t == null) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);

            }
        }
        return ret;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/11 16:05
     *  @Description: 把二叉树打印成多行
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> temp_list = new ArrayList<>();
            while (cnt > 0) {
                cnt--;
                TreeNode t = queue.poll();//出队
                if (t == null) {
                    continue;
                }
                temp_list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if(temp_list.size() != 0){
                ret.add(temp_list);
            }
        }
        return ret;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/11 16:04
     *  @Description: 请实现一个函数按照之字形打印二叉树，
     *  即第一行按照从左到右的顺序打印，
     *  第二层按照从右至左的顺序打印，
     *  第三行按照从左到右的顺序打印，
     *  其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        boolean reverse = false;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp_list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt > 0) {
                cnt--;
                TreeNode t = queue.poll();//出队
                if (t == null) {
                    continue;
                }
                temp_list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            //加上一个状态控制 变量
            if (reverse) {
                Collections.reverse(temp_list);
            }
            ret.add(temp_list);
            reverse = !reverse;
        }
        return ret;
    }
}
