package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/13 18:32
 * @description：  从中序与后序遍历序列构造二叉树
 * @modified By：
 * @version: $
 */
public class Leet106_reConstructBTreeInAndPost {


    public TreeNode buildTree1(int[] inorder, int[] postorder) {

        return  build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder,int inl, int inr, int[] postorder, int pl, int pr) {

        if (inl > inr || pl > pr) {
            return null;
        }

        int val = postorder[pr];

        TreeNode root = new TreeNode(val);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        root.left = build(inorder, inl, i - 1, postorder, pl, pl + i - inl - 1);
        root.right = build(inorder, i + 1, inr, postorder, pl + i - inl, pr - 1);

        return root;

    }

    //2
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int inLow,int inHigh,
                               int[] postorder,int postLow, int postHigh){

        if(inLow > inHigh || postLow > postHigh){
            return null;
        }
        //根节点值 为 后序遍历最后一个值
        int rootVal = postorder[postHigh];


        TreeNode root = new TreeNode(rootVal);
        //找到rootVal 在 inorder 中的位置
        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                // 注意下标！！！ post 的下标是 根据 in 中 left部分 的长度（i-1-inLow） 计算出来的
                root.left = buildTree(inorder,inLow,i-1,postorder, postLow,  postLow + i - inLow - 1);
                //postHigh - 1  缩短长度
                root.right = buildTree(inorder,i+1,inHigh,postorder,postLow + i - inLow ,postHigh - 1);  //
                break;

            }
        }
        return root;
    }
}
