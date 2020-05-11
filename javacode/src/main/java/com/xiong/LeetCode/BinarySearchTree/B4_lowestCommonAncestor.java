package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/21 16:34
 * @description： 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * @modified By：
 * @version: $
 */
public class B4_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left_com = lowestCommonAncestor(root.left, p, q);

        TreeNode right_com = lowestCommonAncestor(root.right, p, q);
        //左子树找不到 直接返回右子树的结果
        if (left_com == null){
            return right_com;
        }

        if (right_com == null ){
            return left_com;
        }

        // 两个 都不为null 证明 一个为p  一个为 q 直接返回 root 即为最低公共祖先
        return root;

    }
}
