package com.xiong.LeetCode.JianZhiOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/7 11:23
 * @description： 面试题33. 二叉搜索树的后序遍历序列
 * 还有一种单调栈的做法  反正我是没看懂
 * @modified By：
 * @version: $
 */
public class J33_verifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 1) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int begin, int end) {

        if (begin >= end) {
            return true;
        }

        int root = postorder[end];

        //找到 比 root 大的第一个数 即右子树的元素
        int i;
        for (i = begin; i < end; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        // [1 3 2 6 5]  ---> 左 ：[1 3 2]  中： 5  右： [6]
        // [4, 8, 6, 12, 16, 14, 10] -----> [4, 8, 6]  10  [12, 16, 14]
        // 判断 这个数（12）  右边的元素(不包括 root) 是否小于 root
        // 小于 则 返回false
        for (int j = i; j < end; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }
        // 对小于根节点的所有元素  和 大于根节点的所有元素 分别递归
        return verifyPostorder(postorder, begin, i - 1) && verifyPostorder(postorder, i, end - 1);
    }

    //    作者：burning-summer
    //    链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/dan-diao-di-zeng-zhan-by-shi-huo-de-xia-tian/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean verifyPostorder_stack(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > pervElem) {
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                pervElem = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}
