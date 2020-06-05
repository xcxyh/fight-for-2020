package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/31 18:00
 * @description： 面试题26. 树的子结构
 * @modified By：
 * @version: $
 */
public class J26_isSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){ //空树不是任意一个树的子结构
            return false;
        }
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断 b是否是 以 a 为根节点的树的子结构
    private boolean isSub(TreeNode a, TreeNode b){
        if (b == null){
            return true;
        }
        if (a == null){
            return false;
        }

        return a.val == b.val && isSub(a.left, b.left) && isSub(a.right, b.right);
    }
}
