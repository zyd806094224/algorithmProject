package com.algorithm;

import com.algorithm.entity.TreeNode;

/**
 * 二叉搜索树转换为双向链表  返回双向链表头结点
 */
public class JZ36 {

    public static void main(String[] args) {
        TreeNode convert = convert(TreeNode.getATreeNode());
    }

    public static TreeNode convert(TreeNode pRootOfTree) {
        process(pRootOfTree);
        return head;
    }

    static TreeNode prev = null;
    static TreeNode head = null;

    private static void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (prev == null) {
            prev = root;
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
            prev = root;
        }
        process(root.right);
    }
}
