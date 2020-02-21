package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/18 15:40
 * @description： 非递归实现 二叉树的 前 中 后 序遍历
 * <p>
 * 利用栈来实现
 * @modified By：
 * @version: $
 */
public class B14_NonRecursiveTraverse {


    /**
     * @author: xiongcong
     * @Date: 2020/2/18 15:41
     * @Description: 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            //出栈根节点
            TreeNode node = stack.pop();
            //有节点为空 跳过
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            //先入栈右节点 后左  这样 出栈时 就是  根  左  右
            stack.push(node.right); // 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return ret;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/18 15:41
     * @Description: 中序遍历（难）
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //一直入栈左节点 直到找到最左节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //以最左节点为起点 弹栈一个
            TreeNode node = stack.pop();
            ret.add(node.val);
            //cur指向一个右节点
            cur = node.right;

        }
        return ret;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/18 15:41
     * @Description: 后序遍历 （根据前序遍历改造）
     * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
     * 可以修改前序遍历成为 root -> right -> left，
     * 那么这个顺序就和后序遍历正好相反。
     * 然后再将 结果集 反序
     *
     */
    public List<Integer> lastorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //出栈根节点
            TreeNode node = stack.pop();
            //有节点为空 跳过
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            stack.push(node.left); // 先左后右，保证和 后序遍历 顺序相反
            stack.push(node.right);
        }
        //反序
        Collections.reverse(ret);
        return ret;
    }


}
