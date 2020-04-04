package com.xiong.LeetCode.FenZhi;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/1 18:16
 * @description：  95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成**所有**由 1 ... n 为节点所组成的二叉搜索树。
 * @modified By：
 * @version: $
 */
public class Leet95_generateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0){
            return new ArrayList<>();
        }
       return generateTree(1,n);
    }
    //从 m 到 n 的所有 TreeNode
    private List<TreeNode> generateTree(int m , int n){
        List<TreeNode> ans = new ArrayList<>();
        if(m > n){
            ans.add(null);
            return ans;
        }
        for (int i = m; i <= n ; i++) {
            List<TreeNode> lefts = generateTree(m, i - 1);  // 分治
            List<TreeNode> rights = generateTree(i + 1, n); //分治
            for (TreeNode l: lefts) {  //取 笛卡尔积
                for (TreeNode r: rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }

}
