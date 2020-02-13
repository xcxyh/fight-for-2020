package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/10 20:06
 * @description： 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 分析：
 * ··1 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
 * ··2 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
 * @modified By：
 * @version: $
 */
public class J08_BTreeGetNext {
    public static void main(String[] args) {
        System.out.println();
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {   //该节点的右节点不为空
        if(pNode.right != null){
            //取右节点
            TreeLinkNode node = pNode.right;
            //循环 来找到该右节点的最左节点
            while(node.left != null){
                node = node.left;
            }
            //返回该最左节点
            return node;
        }else{//当前节点的右节点为空
            //这里的 father 是指向父节点的指针 即判断当前节点的父节点是否为空
            while(pNode.father != null){
                TreeLinkNode father = pNode.father;
                //找第一个左链接指向的树包含该节点的祖先节点
                //如果该条件不满足  代表  pNode 为 father 的右节点
                if(father.left == pNode){
                    return father;
                }
                //继续向上找
                //当前节点的父节点 -> 当前节点
                pNode = pNode.father;
            }
        }
        return null;
    }
}
