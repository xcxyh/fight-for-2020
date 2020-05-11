package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/13 12:42
 * @description：  判断一个 序列是否是 一个二叉搜索树的 后序遍历
 * @modified By：
 * @version: $
 */
public class J33_VerifySeqOfBST {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 1){
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int begin, int end){

        if (begin >= end){
            return true;
        }

        int root = postorder[end];

        //找到 比 root 大的第一个数 即右子树的元素
        int i;
        for (i = begin; i < end ; i++){
            if (postorder[i] > root){
                break;
            }
        }
       // [1 3 2 6 5]  ---> 左 ：[1 3 2]  中： 5  右： [6]
        // [4, 8, 6, 12, 16, 14, 10] -----> [4, 8, 6]  10  [12, 16, 14]
        // 判断 这个数（12）  右边的元素(不包括 root) 是否小于 root
        // 小于 则 返回false
        for(int j = i; j < end; j++){
            if (postorder[j] < root ){
                return false;
            }
        }
        // 对小于根节点的所有元素  和 大于根节点的所有元素 分别递归
        return verifyPostorder(postorder,begin, i- 1 ) && verifyPostorder(postorder, i, end - 1);
    }

}
