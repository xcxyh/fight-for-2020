package com.xiong.LeetCode.StringsProblem;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/18 10:16
 * @description： 1028. 从先序遍历还原二叉树
 * @modified By：
 * @version: $
 */
public class Leet1028_recoverFromPreorder {



    //ac答案 太慢
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0){
            return null;
        }

        // 处理 S 得到 左子树的 subS 和 右子树的 subS 然后递归

        char[] chars = S.toCharArray();
        for(int i = 0; i < S.length(); i++){
            if (chars[i] == '-'
                    && Character.isDigit(chars[i-1]) && Character.isDigit(chars[i+1])){
                chars[i] = ',';
            }
        }
        S = String.valueOf(chars);
        String[] strs = new String[3];
        String[] temp = S.split(",");
        System.arraycopy(temp, 0, strs, 0, temp.length);

        int val = strToNum(strs[0]);

        String S_left = deleteDash(strs[1]);
        String S_right = deleteDash(strs[2]);

        //System.out.println(S_left);

        TreeNode root = new TreeNode(val);

        root.left = recoverFromPreorder(S_left);

        root.right = recoverFromPreorder(S_right);

        return root;
    }

    //所有的连续的短横线长度 减一
    private String deleteDash(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if (chars[i] == '-'
                    && Character.isDigit(chars[i-1]) && chars[i + 1] == '-'){
                chars[i] = ' ';
            }else{
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    //字符串转 数字
    private int strToNum(String s){
        int ans = 0;
        for(char c : s.toCharArray()){
            ans = ans * 10 + (c - '0');
        }
        return ans;
    }
}
