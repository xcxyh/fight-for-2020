package com.xiong.LeetCode.BackTracking;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/4 13:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet988_smallestFromLeaf {

    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {


        dfs(root, new StringBuilder());

        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null) {
            // reverse
            sb.reverse();
            String tempS = sb.toString();

            if (tempS.compareTo(ans)< 0) {
                ans = tempS;
            }
            sb.reverse();
        }

        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}
