package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/13 12:42
 * @description：  判断一个 序列是否是 一个二叉搜索树的 后序遍历
 * @modified By：
 * @version: $
 */
public class J33_VerifySeqOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length ==0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);

    }

    public boolean verify(int [] sequence, int begin, int end){

        if(sequence.length == 1){
            return true;
        }

        //取出 序列中最后一个值 即根节点
        // 将 序列分为两部分 判断 右半部分是否有小于root的 有则为fasle  左半部分不用判断
        int root = sequence[end];
        int i = begin;
        //找到第一个大于root的节点
        while(i < end){
            if(sequence[i] > root){
                break;
            }
            i++;
        }
        //判断 右半部分是否有小于root的
        int j = i;
        while (j < end){
           if(sequence[j] < root){
               return false;
           }
           j++;
       }

        //对 小于根节点的 左子树 继续递归
        // 对 大于根节点的 右子树 继续递归
        return verify(sequence,begin,i - 1) && verify(sequence,i, end-1);


    }

}
