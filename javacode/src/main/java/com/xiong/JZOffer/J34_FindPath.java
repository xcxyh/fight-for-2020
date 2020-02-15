package com.xiong.JZOffer;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/14 15:23
 * @description： 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @modified By：
 * @version: $
 */
public class J34_FindPath {
    //递归中的全局变量
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();


    public static void main(String[] args) {
        //二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(12);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(7);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        ArrayList<ArrayList<Integer>> list = new J34_FindPath().findPath(root, 22);

        for (ArrayList<Integer> it:list) {
            for (int i = 0; i <it.size() ; i++) {
                System.out.print(it.get(i) + " ");
            }
            System.out.println();
        }
    }


    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        //深度优先搜索 中的 回溯
        backtracking(root, target, new ArrayList<Integer>());
        return ret;
    }

    public void backtracking(TreeNode root, int target, ArrayList<Integer> temp) {

        if (root == null) {
            return;
        }
        target = target - root.val;
        temp.add(root.val);
        //回溯约束条件  满足条件的添加到 全局变量中
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(temp));//这里必须新建一个 不然添加进去的都是同一个对象
        }
        if (root.left != null) {
            backtracking(root.left, target, temp);
        }
        if (root.right != null) {
            backtracking(root.right, target, temp);
        }
        //回溯 弹栈时
        if (temp.size() != 0) {
            temp.remove(temp.size() - 1);
        }

    }
}
