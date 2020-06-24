package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/18 10:39
 * @description：  面试题37. 序列化二叉树  leet297     DFS  或者是 BFS 都可以解
 * @modified By：
 * @version: $
 */
public class J37_Codec {

    //这里我们选择简单的 DFS 写法 ，但是 效率低

    private String serialize(TreeNode root,String str) {
        if (root == null){
            str += "Null,";
            return str;
        }


        str += String.valueOf(root.val) + ",";

        str = serialize(root.left, str);

        str = serialize(root.right, str);

        return str;

    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");

        List<String> list = new ArrayList<>(Arrays.asList(strs));

        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if ("Null".equals(list.get(0))){
            list.remove(0);
            return null;
        }

        int val = Integer.valueOf(list.get(0));
        list.remove(0);

        TreeNode root = new TreeNode(val);

        root.left = deserialize(list);
        root.right = deserialize(list);

        return root;
    }

}
