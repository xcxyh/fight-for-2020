package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/16 11:07
 * @description： 297. 二叉树的序列化与反序列化
 * @modified By：
 * @version: $
 */
public class Leet297_Codec_DFS {

    private String serialize(TreeNode root, String str){
        if (root == null){
            str += "Null,"; // 注意 要加个 ，逗号
        }else {
            str += root.val + ",";
            // 加上 左子树的序列化结果  不需要 str += 因为 传入的 是 str
            str = serialize(root.left, str);
            // 加上 右子树的序列化结果  不需要 str += 因为 传入的 是 str
            str = serialize(root.right, str);
        }

        return str;

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String ans = serialize(root, "");
        //System.out.println(ans);
        return ans;
    }

    private TreeNode deserialize(List<String> list) {
        if ("Null".equals(list.get(0))){
            // 用一个 删除一个
            list.remove(0);
            return null;
        }
        int val = Integer.valueOf(list.get(0));
        // 用一个 删除一个
        list.remove(0);
        TreeNode node = new TreeNode(val);

        node.left = deserialize(list);
        node.right = deserialize(list);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strs = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        return deserialize(list);
    }
}
