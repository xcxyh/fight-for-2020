package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.HashMap;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/17 16:53
 * @description： 二叉树间隔遍历
 *
 * 解法：
 * 分情况遍历：
 * 1 路径中包含根节点
 * 2 不包含根节点 （以根节点为间隔）
 * @modified By：
 * @version: $
 */
public class B10_rob {

    // 纯递归的方式，效率低
    //执行用时：949 ms, 在所有 Java 提交中击败了 12.50%

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 爷爷 + 4 个孙子的结果
        int robCur = root.val;
        if (root.left != null){
            robCur += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            robCur += rob(root.right.left) + rob(root.right.right);
        }
        // 两个 儿子的结果
        int notRobCur = rob(root.left) + rob(root.right);

        return Math.max(robCur, notRobCur);

    }


    // 使用 hashmap 优化 ，消除重复计算
    //执行用时：3 ms, 在所有 Java 提交中击败了58.80% 的用户

    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int robMemo(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (map.containsKey(root)){
            return map.get(root);
        }
        // 爷爷 + 4 个孙子的结果
        int robCur = root.val;
        if (root.left != null){
            robCur += robMemo(root.left.left) + robMemo(root.left.right);
        }
        if (root.right != null){
            robCur += robMemo(root.right.left) + robMemo(root.right.right);
        }
        // 两个 儿子的结果
        int notRobCur = robMemo(root.left) + robMemo(root.right);

        int curMax = Math.max(robCur, notRobCur);

        map.put(root, curMax);

        return curMax;
    }

    // 最优解法
    //执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户

    public int robPref(TreeNode root) {

        int[] cur = robIt(root);

        return Math.max(cur[0], cur[1]);

    }
    // 返回两个值， 一个为 robCur， 一个为 notRobCur

    private int[] robIt(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }

        int[] left = robIt(root.left);
        int[] right = robIt(root.right);

        int robCur = root.val + left[1] + right[1];
        // 当 不抢当前节点时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系) !!!!
        int notRobCur = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robCur, notRobCur};

    }

}
