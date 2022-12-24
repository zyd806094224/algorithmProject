package com.algorithm;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 */
public class GetTreeLinkNodeNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //有右子树
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //没有右子树，但是是父节点的左孩子
        if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        //没有右子树，但是是父节点的右孩子
        if(pNode.next != null){
            pNode = pNode.next;
            while(pNode.next != null && pNode.next.right == pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
