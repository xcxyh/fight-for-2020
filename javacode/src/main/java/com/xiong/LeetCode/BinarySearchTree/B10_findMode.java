package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/23 16:36
 * @description： 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class B10_findMode {
    /**
     * @author: xiongcong
     * @Date: 2020/2/23 16:36
     * @Description: 由于出现频率最高的元素可能有多个
     * 所以返回一个数组
     *
     * 可中序遍历得到 有序递增数组 转化为求有序数组的 众数问题
     */
    private ArrayList<Integer> list = new ArrayList<>();

    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if (preNode != null) {
            if (preNode.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            list.clear();
            list.add(root.val);
        } else if (curCnt == maxCnt) {
            list.add(root.val);
        }
        //pre 指针指向当前节点
        preNode = root;
        inorder(root.right);

    }

}
