package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/13 18:48
 * @description： 从前序与中序遍历序列构造二叉树
 * @modified By：
 * @version: $
 */
public class Leet105_reConstructBTreeInAndPre {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        return buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int inLow,int inHigh,
                               int[] preorder,int preLow, int preHigh){

        if(inLow > inHigh || preLow > preHigh){
            return null;
        }

        int rootVal = preorder[preLow];
        TreeNode root = new TreeNode(rootVal);

        //inorder 中找到 rootVal 的位置
        for(int i = 0; i< inorder.length ; i++){
            if (rootVal == inorder[i]){
                //preLow + 1  与 leet 106 中的 postHigh - 1 区分开
                root.left = buildTree(inorder,inLow,i - 1,preorder,preLow + 1,preLow + i- inLow);
                root.right = buildTree(inorder,i + 1,inHigh,preorder,preLow + i-inLow + 1, preHigh);
                break;
            }
        }
        return root;
    }
}
