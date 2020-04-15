package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 11:57
 * @description： 二叉树的序列化与反序列化
 * @modified By：
 * @version: $
 */
public class Leet297_serializeAnddeserialize {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //层次遍历
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> q = new LinkedList<>();
        //sb.append("[");
        q.offer(root);
        sb.append(root.val);
        //每层之间用','隔开, 一层中每个元素之间用 # 隔开
        while (!q.isEmpty()) {
            int size = q.size();
            sb.append(',');
            while (size-- > 0) {
                TreeNode t = q.poll();
                if (t.left != null) {
                    q.offer(t.left);
                    sb.append("#" + t.left.val);
                } else {
                    sb.append("#null");
                }
                if (t.right != null) {
                    q.offer(t.right);
                    sb.append("#" + t.right.val);
                } else {
                    sb.append("#null");
                }
            }

        }
        //sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        }
        //分割出每层
        String[] layers = data.split(",");
        //根节点
        TreeNode root = new TreeNode(Integer.parseInt(layers[0]));
        Queue<TreeNode> q = new LinkedList<>();//用于存储上一层的node

        q.offer(root);
        int i = 0;
        while (++i < layers.length) { // ++i 防止 索引越界
            //分割，得到当前层的节点
            String[] nodes = layers[i].substring(1).split("#");
            int size = q.size();
            int k = 0;
            //将当前层的节点和上一层连接起来 即
            //上一层的 左右node 指向当前层
            while (size-- > 0 && k < nodes.length) {
                TreeNode t = q.poll();
                if (!"null".equals(nodes[k])) {
                    t.left = new TreeNode(Integer.parseInt(nodes[k]));
                    q.offer(t.left);
                } else {
                    t.left = null;
                }
                if (!"null".equals(nodes[k + 1])) {
                    t.right = new TreeNode(Integer.parseInt(nodes[k + 1]));
                    q.offer(t.right);
                } else {
                    t.right = null;
                }
                k = k + 2;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        String ans = serialize(t1);
        System.out.println(ans);
        TreeNode treeNode = deserialize(ans);
        System.out.println(treeNode);

    }
}
